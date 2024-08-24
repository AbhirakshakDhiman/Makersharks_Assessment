To Run this Springboot Rest API, You have to do some following steps

1. Download zip file and extract it.

2. Add into to your eclipse IDE

3. Goto terminal and goto this folder

4. Run this commnad in terminal:mvn spring-boot:run

5.Your Api will start

6.Open  command prompt and write the following curl command to add a new supplier
   >>curl -X POST "http://localhost:8080/api/supplier/new" -H "Content-Type: application/json" -d "{\"location\": \"India\", \"natureOfBusiness\": \"LARGE_SCALE\", \"manufacturingProcesses\": [\"MOULDING\"]}"
   
   You will get this type of response
   >>{
    "supplierId": 6,
    "companyName": "TechMould5 Inc.",
    "website": "http://techmould5.com",
    "location": "London",
    "natureOfBusiness": "LARGE_SCALE",
    "manufacturingProcesses": [
        "_3D_PRINTING"
    ]
}

7. write the following curl command to query suppliers
   >>curl -X POST "http://localhost:8080/api/supplier/query" -H "Content-Type: application/json" -d "{\"location\": \"India\", \"natureOfBusiness\": \"SMALL_SCALE\", \"manufacturingProcesses\": [\"MOULDING\", \"CASTING

   You will get this type of response
   >>'{
    "totalElements": 3,
    "totalPages": 1,
    "size": 10,
    "content": [
        {
            "supplierId": 1,
            "companyName": "TechMould Inc.",
            "website": "http://techmould.com",
            "location": "India",
            "natureOfBusiness": "SMALL_SCALE",
            "manufacturingProcesses": [
                "MOULDING",
                "CASTING"
            ]
        },
        {
            "supplierId": 2,
            "companyName": "TechMould2 Inc.",
            "website": "http://techmould2.com",
            "location": "India",
            "natureOfBusiness": "SMALL_SCALE",
            "manufacturingProcesses": [
                "CASTING"
            ]
        },
        {
            "supplierId": 3,
            "companyName": "TechMould3 Inc.",
            "website": "http://techmould3.com",
            "location": "India",
            "natureOfBusiness": "SMALL_SCALE",
            "manufacturingProcesses": [
                "MOULDING",
                "CASTING"
            ]
        }
    ],
    "number": 0,
    "sort": {
        "empty": true,
        "sorted": false,
        "unsorted": true
    },
    "first": true,
    "last": true,
    "numberOfElements": 3,
    "pageable": {
        "pageNumber": 0,
        "pageSize": 10,
        "sort": {
            "empty": true,
            "sorted": false,
            "unsorted": true
        },
        "offset": 0,
        "paged": true,
        "unpaged": false
    },
    "empty": false
}'
