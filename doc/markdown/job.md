

## JobAction

### search

- Description

> return a page containing jobs qualified for the given filter

- URL

> http://localhost:8080/backend/job/search

- Parameters

    |parameter|required|type|note|
    |:----- |:-------|:-----|----- |
    |jobType |ture |String|must be AUTOBOT or TRAINER|
    |businessCategories |no |String |business categories concated by ',' |
    |regionId|no|int| |
    |publishTime|no|String|publish time restriction, count by day, include the min value the max value separated by a comma| 
    |workExperienceRequirement|no|String|count by year, include the min value the max value separated by a comma|
    |keyword|no|String|text to search job info|

- Response
 

- Example
 
    - url : http://localhost:8080/backend/job/search
    - post data: 
 
            {
                jobType : "TRAINER",
                businessCategory : aaa,bbb,ccc,
                regionId : "1",
                publishTime : ",3",
                workExperienceRequirement : "5,10",
                keyword : "lalala"
            }
            
    - response : html file
    
    
---------------------------------------



