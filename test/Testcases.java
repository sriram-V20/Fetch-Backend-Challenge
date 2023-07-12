public class Testcases {

    public static final String json1 = "{\n" +
            "    \"retailer\": \"Target\",\n" +
            "    \"purchaseDate\": \"2022-01-01\",\n" +
            "    \"purchaseTime\": \"13:01\",\n" +
            "    \"items\": [\n" +
            "        {\n" +
            "            \"shortDescription\": \"Mountain Dew 12PK\",\n" +
            "            \"price\": \"6.49\"\n" +
            "        },\n" +
            "        {\n" +
            "            \"shortDescription\": \"Emils Cheese Pizza\",\n" +
            "            \"price\": \"12.25\"\n" +
            "        },\n" +
            "        {\n" +
            "            \"shortDescription\": \"Knorr Creamy Chicken\",\n" +
            "            \"price\": \"1.26\"\n" +
            "        },\n" +
            "        {\n" +
            "            \"shortDescription\": \"Doritos Nacho Cheese\",\n" +
            "            \"price\": \"3.35\"\n" +
            "        },\n" +
            "        {\n" +
            "            \"shortDescription\": \"   Klarbrunn 12-PK 12 FL OZ  \",\n" +
            "            \"price\": \"12.00\"\n" +
            "        }\n" +
            "    ],\n" +
            "    \"total\": \"35.35\",\n" +
            "    \"expectedPoints\" : 28\n" +
            "}";

    public static final String json2 = "{\n" +
            "    \"retailer\": \"M&M Corner Market\",\n" +
            "    \"purchaseDate\": \"2022-03-20\",\n" +
            "    \"purchaseTime\": \"14:33\",\n" +
            "    \"items\": [\n" +
            "        {\n" +
            "            \"shortDescription\": \"Gatorade\",\n" +
            "            \"price\": \"2.25\"\n" +
            "        },\n" +
            "        {\n" +
            "            \"shortDescription\": \"Gatorade\",\n" +
            "            \"price\": \"2.25\"\n" +
            "        },\n" +
            "        {\n" +
            "            \"shortDescription\": \"Gatorade\",\n" +
            "            \"price\": \"2.25\"\n" +
            "        },\n" +
            "        {\n" +
            "            \"shortDescription\": \"Gatorade\",\n" +
            "            \"price\": \"2.25\"\n" +
            "        }\n" +
            "    ],\n" +
            "    \"total\": \"9.00\",\n" +
            "    \"expectedPoints\" : 109\n" +
            "}";


    public static final String json3 = "{\n" +
            "    \"retailer\": \"walmart\",\n" +
            "    \"purchaseDate\": \"2022-03-21\",\n" +
            "    \"purchaseTime\": \"16:00\",\n" +
            "    \"items\": [\n" +
            "        {\n" +
            "            \"shortDescription\": \"chicken breast Boneless\",\n" +
            "            \"price\": \"12.25\"\n" +
            "        },\n" +
            "        {\n" +
            "            \"shortDescription\": \"pineapple\",\n" +
            "            \"price\": \"4.25\"\n" +
            "        },\n" +
            "        {\n" +
            "            \"shortDescription\": \"MinuteMaid juice pulp\",\n" +
            "            \"price\": \"5.25\"\n" +
            "        },\n" +
            "        {\n" +
            "            \"shortDescription\": \"apples\",\n" +
            "            \"price\": \"2.25\"\n" +
            "        }\n" +
            "    ],\n" +
            "    \"total\": \"24.00\",\n" +
            "    \"expectedPoints\" : 102\n" +
            "}";

    public static final String json4 = "{\n" +
            "    \"retailer\": \"Food4Less\",\n" +
            "    \"purchaseDate\": \"2023-07-03\",\n" +
            "    \"purchaseTime\": \"15:00\",\n" +
            "    \"items\": [\n" +
            "        {\n" +
            "            \"shortDescription\": \"Japanese Suntory whiskey\",\n" +
            "            \"price\": \"12.25\"\n" +
            "        }\n" +
            "    ],\n" +
            "    \"total\": \"12.25\",\n" +
            "    \"expectedPoints\" : 53\n" +
            "}";

    public static final String json5 = "{\n" +
            "    \"retailer\": \"Food4Less\",\n" +
            "    \"purchaseDate\": \"2023-07-03\",\n" +
            "    \"purchaseTime\": \"15:00\",\n" +
            "    \"items\": [],\n" +
            "    \"total\": \"0.00\",\n" +
            "    \"expectedPoints\" : 25\n" +
            "}";
}
