package com.car.training.tasks;

import com.car.training.action.backend.UserCenterAction;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component("ScheduledTasks")
public class ScheduledTasks {
    
    @Autowired
    SessionFactory sessionFactory;

    public void updateTrainerRank() {
        Session session = sessionFactory.openSession();
        
        session.createSQLQuery("update Trainer left join loginUser on Trainer.loginUser_id = loginUser.id left join\n" +
                "(SELECT COUNT(*) cmt_num, targetUserId FROM Comment GROUP BY Comment.targetUserId) cmt on loginUser.id = cmt.targetUserId left join\n" +
                "(SELECT COUNT(*) lk_num, targetUserId FROM `Like` GROUP BY `Like`.targetUserId) lk on loginUser.id = lk.targetUserId left join\n " +
                "PersonInfo on Trainer.personInfo_id = PersonInfo.id\n"+
                "set rank =  IFNULL(cmt_num, 0)+ IFNULL(lk_num, 0), rank2 =IFNULL(cmt_num, 0) ,rank3 = IF(PersonInfo.avatarUrl='"+ UserCenterAction.defaultAvatar +"' ,0, 1) ;").executeUpdate();
        session.createSQLQuery("UPDATE Autobot LEFT JOIN loginUser ON Autobot.loginUser_id = loginUser.id LEFT JOIN\n" +
                "(SELECT COUNT(*) cmt_num, targetUserId FROM Comment GROUP BY Comment.targetUserId) cmt ON loginUser.id = cmt.targetUserId LEFT JOIN\n" +
                "(SELECT COUNT(*) lk_num, targetUserId FROM `Like` GROUP BY `Like`.targetUserId) lk ON loginUser.id = lk.targetUserId LEFT JOIN\n" +
                "PersonInfo on Autobot.personInfo_id = PersonInfo.id\n"+
                "set rank =  IFNULL(cmt_num, 0)+ IFNULL(lk_num, 0), rank2 =IFNULL(cmt_num, 0),rank3 = IF(PersonInfo.avatarUrl='"+ UserCenterAction.defaultAvatar +"' ,0, 1)  ;").executeUpdate();
        session.close();
    }

    public void updateAutobotRank() {
    }
}