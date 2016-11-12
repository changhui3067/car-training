DROP TABLE IF EXISTS autobots;
CREATE TABLE autobot (
  id             INT          NOT NULL,
  username       VARCHAR(50)  NOT NULL,
  workingStatus  VARCHAR(50)  NOT NULL,
  autoYears      INT          NOT NULL,
  autoBrand      VARCHAR(50)  NOT NULL,
  business       VARCHAR(100) NOT NULL,
  certRecords    VARCHAR(500) NOT NULL,
  workingHistory VARCHAR(500) NOT NULL,
  userinfo       INT          NOT NULL
);

DROP TABLE IF EXISTS oldTrainer;
CREATE TABLE oldTrainer (
  id                INT          NOT NULL,
  username          VARCHAR(50)  NOT NULL,
  education         VARCHAR(50)  NOT NULL,
  executionCategory VARCHAR(200) NOT NULL,
  businessCategory  VARCHAR(200) NOT NULL,
  autoYears         INT          NOT NULL,

  introduction      TEXT         NOT NULL,
  mainCourse        VARCHAR(50)  NOT NULL,
  videoUrl1         VARCHAR(200),
  videoUrl2         VARCHAR(200)
);

DROP TABLE IF EXISTS loginUser;
CREATE TABLE loginUser (
  id       INT         NOT NULL,
  username VARCHAR(50) NOT NULL,
  password VARCHAR(50) NOT NULL,
  type     VARCHAR(50) NOT NULL
);


DROP TABLE IF EXISTS personInfo;
CREATE TABLE personInfo (
  id             INT          NOT NULL,
  username       VARCHAR(50)  NOT NULL,
  birthday       VARCHAR(50),
  name           VARCHAR(50)  NOT NULL,
  gender         VARCHAR(50)  NOT NULL,
  mobile         VARCHAR(50),
  email          VARCHAR(50),
  marriageStatus VARCHAR(50)  NOT NULL,
  regionId       INT          NOT NULL,
  avatarURL      VARCHAR(200) NOT NULL
);


DROP TABLE IF EXISTS company;
CREATE TABLE company (
  id           INT          NOT NULL,
  username     VARCHAR(50)  NOT NULL,
  name         VARCHAR(50)  NOT NULL,
  address      VARCHAR(200) NOT NULL,
  regionId     INT          NOT NULL,
  logoUrl      VARCHAR(200) NOT NULL,
  companyType  VARCHAR(50)  NOT NULL,
  introduction VARCHAR(500)
);


DROP TABLE IF EXISTS article;
CREATE TABLE article (
  id               INT         NOT NULL,
  title            VARCHAR(50) NOT NULL,
  content          LONGTEXT    NOT NULL,
  trainer_id       VARCHAR(50) NOT NULL,
  createDate       DATETIME,
  lastModifiedDate DATETIME
);


DROP TABLE IF EXISTS job;
CREATE TABLE job (
  id                        INT         NOT NULL,
  title                     VARCHAR(50) NOT NULL,
  publishCompanyId          INT         NOT NULL,
  workExperienceRequirement INT         NOT NULL,
  regionId                  INT         NOT NULL,
  educationRequirement      VARCHAR(50) NOT NULL,
  salary                    VARCHAR(50) NOT NULL,
  jobDescription            LONGTEXT
);


DROP TABLE IF EXISTS comment;
CREATE TABLE comment (
  id           INT      NOT NULL,
  userId       INT      NOT NULL,
  targetuserId INT      NOT NULL,
  content      LONGTEXT NOT NULL
);

DROP TABLE IF EXISTS likes;
CREATE TABLE likes (
  id           INT NOT NULL,
  userId       INT NOT NULL,
  targetuserId INT NOT NULL
);

DROP TABLE IF EXISTS guarantee;
CREATE TABLE guarantee (
  id        INT NOT NULL,
  userId    INT NOT NULL,
  companyId INT NOT NULL
);


CREATE TABLE Trainer (
  id                VARCHAR(255) NOT NULL AUTO_INCREMENT,
  autoYears         INTEGER,
  businessCategory  VARCHAR(255),
  education         VARCHAR(255),
  executionCategory VARCHAR(255),
  introduction      VARCHAR(255),
  mainCourse        VARCHAR(255),
  videoUrl1         VARCHAR(255),
  videoUrl2         VARCHAR(255),
  PRIMARY KEY (id)
)