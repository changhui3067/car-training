package com.car.training.dao.impl;

import com.car.training.bean.Autobot;
import com.car.training.bean.Job;
import com.car.training.bean.Trainer;
import com.car.training.dao.PromotionDAO;
import org.hibernate.Query;
import org.hibernate.SQLQuery;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.sql.Timestamp;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

/**
 * Created by bill on 11/21/16.
 */
@Repository
public class HibernatePromotionDAO implements PromotionDAO {

    @Autowired
    SessionFactory sessionFactory;

    @Override
    public boolean isUpTodate() {

        SQLQuery query = sessionFactory.getCurrentSession().createSQLQuery("SELECT min(updateDate) FROM Promotion");
        List list = query.list();
        if (list != null && list.size() > 0) {
            Timestamp time = (Timestamp) list.get(0);
            if (time != null) {
                Calendar calendar = Calendar.getInstance();
                calendar.setTime(time);
                calendar.add(Calendar.DATE, 1);
                Calendar c2 = Calendar.getInstance();
                c2.setTime(new Date());
                if (calendar.after(c2)) {
                    return true;
                }
            }
        }
        return false;
    }

    @Override
    public List getTopUser(Class tClass) {
        String hql;
        if (tClass == Trainer.class) {
            hql = "select trainer from Trainer as trainer join trainer.loginUser as loginUser, Promotion pro where loginUser.id=pro.entityId and pro.entityType='TRAINER' order by pro.ord";

        } else if (tClass == Autobot.class) {
            hql = "select autobot from Autobot as autobot join autobot.loginUser as loginUser, Promotion pro where loginUser.id=pro.entityId and pro.entityType='AUTOBOT' order by pro.ord";
        } else {
            return null;
        }
        Query query = sessionFactory.getCurrentSession().createQuery(hql);
        return query.list();
    }

    @Override
    public List<Job> getTopJob(String type) {
        String hql = "select job from Job as job ,Promotion pro where job.id=pro.entityId and pro.entityType=:type order by pro.ord";
        Query query = sessionFactory.getCurrentSession().createQuery(hql);
        query.setString("type",type);
        return query.list();
    }


    @Override
    @Transactional
    public void updatePromotion() {
        String delete_sql = "DELETE FROM Promotion WHERE id > 0;";

        String trainer = "INSERT INTO Promotion (entityId, entityType, updateDate, ord)\n" +
                "  SELECT\n" +
                "    id,\n" +
                "    type,\n" +
                "    now(),\n" +
                "    @rownum\\:=@rownum + 1 AS ord\n" +
                "  FROM (\n" +
                "         SELECT\n" +
                "           IFNULL(cmt_num, 0) * IFNULL(cmt_num, 0) + IFNULL(lk_num, 0) * IFNULL(lk_num, 0) AS weight,\n" +
                "           login.id                                                                           id,\n" +
                "           login.type                                                                         type\n" +
                "         FROM\n" +
                "           ((SELECT\n" +
                "               id,\n" +
                "               type\n" +
                "             FROM loginUser) login LEFT JOIN (SELECT\n" +
                "                                                COUNT(*) cmt_num,\n" +
                "                                                targetUserId\n" +
                "                                              FROM Comment\n" +
                "                                              GROUP BY Comment.targetUserId) cmt ON cmt.targetUserId = login.id\n" +
                "             LEFT JOIN (SELECT\n" +
                "                          COUNT(*) lk_num,\n" +
                "                          targetUserId\n" +
                "                        FROM `Like`\n" +
                "                        GROUP BY targetUserId) lk ON lk.targetUserId = login.id)\n" +
                "         WHERE login.type = 'TRAINER'\n" +
                "         ORDER BY weight DESC\n" +
                "         LIMIT 10) t, (SELECT @rownum\\:=0) r;";

        String autobot = "INSERT INTO Promotion (entityId, entityType, updateDate, ord)\n" +
                "  SELECT\n" +
                "    id,\n" +
                "    type,\n" +
                "    now(),\n" +
                "    @rownum\\:=@rownum + 1 AS ord\n" +
                "  FROM (\n" +
                "         SELECT\n" +
                "           IFNULL(cmt_num, 0) * IFNULL(cmt_num, 0) + IFNULL(lk_num, 0) * IFNULL(lk_num, 0) AS weight,\n" +
                "           login.id                                                                           id,\n" +
                "           login.type                                                                         type\n" +
                "         FROM\n" +
                "           ((SELECT\n" +
                "               id,\n" +
                "               type\n" +
                "             FROM loginUser) login LEFT JOIN (SELECT\n" +
                "                                                COUNT(*) cmt_num,\n" +
                "                                                targetUserId\n" +
                "                                              FROM Comment\n" +
                "                                              GROUP BY Comment.targetUserId) cmt ON cmt.targetUserId = login.id\n" +
                "             LEFT JOIN (SELECT\n" +
                "                          COUNT(*) lk_num,\n" +
                "                          targetUserId\n" +
                "                        FROM `Like`\n" +
                "                        GROUP BY targetUserId) lk ON lk.targetUserId = login.id)\n" +
                "         WHERE login.type = 'AUTOBOT'\n" +
                "         ORDER BY weight\n" +
                "         LIMIT 10) t, (SELECT @rownum\\:=0) r;";

        String company = "INSERT INTO Promotion (entityId, entityType, updateDate, ord)\n" +
                "  SELECT\n" +
                "    id,\n" +
                "    type,\n" +
                "    now(),\n" +
                "    @rownum\\:=@rownum + 1 AS ord\n" +
                "  FROM (SELECT\n" +
                "          com.id,\n" +
                "          login.type,\n" +
                "          now()\n" +
                "        FROM loginUser login\n" +
                "          RIGHT JOIN Company com ON com.loginCompany_id = login.id\n" +
                "          LEFT JOIN (SELECT\n" +
                "                       COUNT(*) g_num,\n" +
                "                       companyId\n" +
                "                     FROM Guarantee\n" +
                "                     GROUP BY companyId) gua ON com.id = gua.companyId\n" +
                "        WHERE login.type = \"COMPANY\"\n" +
                "        ORDER BY g_num\n" +
                "        LIMIT 10) t, (SELECT @rownum\\:=0) r;";

        String store = "INSERT INTO Promotion (entityId, entityType, updateDate, ord)\n" +
                "  SELECT\n" +
                "    id,\n" +
                "    type,\n" +
                "    now(),\n" +
                "    @rownum \\:= @rownum + 1 AS ord\n" +
                "  FROM (SELECT\n" +
                "          com.id,\n" +
                "          login.type,\n" +
                "          now()\n" +
                "        FROM loginUser login\n" +
                "          RIGHT JOIN Company com ON com.loginCompany_id = login.id\n" +
                "          LEFT JOIN (SELECT\n" +
                "                       COUNT(*) g_num,\n" +
                "                       companyId\n" +
                "                     FROM Guarantee\n" +
                "                     GROUP BY companyId) gua ON com.id = gua.companyId\n" +
                "        WHERE login.type = \"STORE\"\n" +
                "        ORDER BY g_num DESC\n" +
                "        LIMIT 10) t,(SELECT @rownum\\:=0) r;";

        String autobot_job = "INSERT INTO Promotion (entityId, entityType, updateDate, ord)\n" +
                "  SELECT\n" +
                "    id,\n" +
                "    \"AUTOBOT_JOB\",\n" +
                "    now(),\n" +
                "    @rownum\\:=@rownum + 1 AS ord\n" +
                "  FROM (\n" +
                "         SELECT\n" +
                "           max(job.id) AS id,\n" +
                "           max(pro.ord)   ford\n" +
                "         FROM Job job\n" +
                "           LEFT JOIN Company com ON job.CompanyId = com.id\n" +
                "           LEFT JOIN Promotion pro ON pro.entityId = com.id\n" +
                "         WHERE com.companyType = \"STORE\"\n" +
                "         GROUP BY com.id\n" +
                "         ORDER BY ford\n" +
                "         LIMIT 10\n" +
                "       ) t, (SELECT @rownum\\:=0) r;";

        String trainer_job = "INSERT INTO Promotion (entityId, entityType, updateDate, ord)\n" +
                "  SELECT\n" +
                "    id,\n" +
                "    \"TRAINER_JOB\",\n" +
                "    now(),\n" +
                "    @rownum\\:=@rownum + 1 AS ord\n" +
                "  FROM (\n" +
                "         SELECT\n" +
                "           max(job.id) AS id,\n" +
                "           max(pro.ord)   ford\n" +
                "         FROM Job job\n" +
                "           LEFT JOIN Company com ON job.CompanyId = com.id\n" +
                "           LEFT JOIN Promotion pro ON pro.entityId = com.id\n" +
                "         WHERE com.companyType = \"COMPANY\"\n" +
                "         GROUP BY com.id\n" +
                "         ORDER BY ford\n" +
                "         LIMIT 10\n" +
                "       ) t, (SELECT @rownum\\:=0) r;";

        Session session = sessionFactory.getCurrentSession();
        session.createSQLQuery(delete_sql).executeUpdate();
        session.createSQLQuery(autobot).executeUpdate();
        session.createSQLQuery(trainer).executeUpdate();
        session.createSQLQuery(company).executeUpdate();
        session.createSQLQuery(store).executeUpdate();
        session.createSQLQuery(autobot_job).executeUpdate();
        session.createSQLQuery(trainer_job).executeUpdate();

//        sessionFactory.getCurrentSession().createSQLQuery(autobot).executeUpdate();
    }

}
