# Car Showroom API

## Tech Stack
- Java 17
- Spring Boot 3.5.5
- Spring Data JPA
- Spring Security
- MySQL Database

## Database Setup

Before running the backend application, you need to set up the database.

1. **Create the Database**  
   - Run the initial SQL script provided in `/scripts/create_DB` to create the database schema.

2. **Insert Sample Data**  
   - After the schema is created and the application is running, you can execute the additional SQL scripts in `/scripts/insert_data` to insert dummy data (users, showrooms, cars, etc.).

3. **Default Test User**  
   - Once the data is inserted, you can log in with the following test credentials:

```

Email: test@t.com
Username: tester
Password: dfghgg

```

## API Reference

---

### Create Car Showroom

```http
POST /api/showrooms
````

**Body Parameters**

| Field                            | Type   | Required | Constraints               |
| :------------------------------- | :----- | :------- | :------------------------ |
| `name`                           | string | Yes      | Max 100 characters        |
| `commercial_registration_number` | string | Yes      | 10 digits, must be unique |
| `manager_name`                   | string | No       | Max 100 characters        |
| `contact_number`                 | string | Yes      | Numeric, max 15 digits    |
| `address`                        | string | No       | Max 255 characters        |

---

### List Car Showrooms

```http
GET /api/showrooms
```

**Query Parameters**

| Parameter | Type    | Description                      |
| :-------- | :------ | :------------------------------- |
| `page`    | integer | Page number (default = 0)        |
| `size`    | integer | Page size (default = 10)         |
| `sortBy`  | string  | Field to sort by                 |
| `sortDir` | string  | Sort direction (`asc` or `desc`) |

**Response Fields**

* `name`
* `commercial_registration_number`
* `contact_number`

---

### Get Specific Car Showroom

```http
GET /api/showrooms/{id}
```

**Path Parameters**

| Parameter | Type   | Description               |
| :-------- | :----- | :------------------------ |
| `id`      | string | **Required**. Showroom ID |

**Response Fields**

* `name`
* `commercial_registration_number`
* `manager_name`
* `contact_number`
* `address`

---

### Update Car Showroom

```http
PATCH /api/showrooms/{id}
```

**Path Parameters**

| Parameter | Type   | Description               |
| :-------- | :----- | :------------------------ |
| `id`      | string | **Required**. Showroom ID |

**Body Parameters**

| Field            | Type   | Required | Constraints            |
| :--------------- | :----- | :------- | :--------------------- |
| `contact_number` | string | No       | Numeric, max 15 digits |
| `manager_name`   | string | No       | Max 100 characters     |
| `address`        | string | No       | Max 255 characters     |

---

### Delete Car Showroom

```http
DELETE /api/showrooms/{id}
```

**Path Parameters**

| Parameter | Type   | Description               |
| :-------- | :----- | :------------------------ |
| `id`      | string | **Required**. Showroom ID |


---

### Create New Car in Showroom

```http
POST /api/showrooms/{showroomId}/car
```

**Path Parameters**

| Parameter    | Type   | Description                          |
| :----------- | :----- | :----------------------------------- |
| `showroomId` | string | **Required**. Associated Showroom ID |

**Body Parameters**

| Field        | Type    | Required | Constraints         |
| :----------- | :------ | :------- | :------------------ |
| `vin`        | string  | Yes      | Max 25 characters   |
| `maker`      | string  | Yes      | Max 25 characters   |
| `model`      | string  | Yes      | Max 25 characters   |
| `model_year` | number  | Yes      | Max 4 digits        |
| `price`      | decimal | Yes      | Valid decimal value |

---

### List Cars with Showroom Details

```http
PATCH /api/car
```

**Query Parameters**

| Parameter | Type    | Description                                    |
| :-------- | :------ | :--------------------------------------------- |
| `page`    | integer | Page number (default = 0)                      |
| `size`    | integer | Page size (default = 10)                       |
| `filter`  | string  | Dynamic filtering ( maker, showroom name, eyc) |

**Response Fields**

* `vin`
* `maker`
* `model`
* `model_year`
* `price`
* `car_showroom_name`
* `contact_number`


### User Login

```http
POST /api/login
````

**Body Parameters (DTO)**

| Field      | Type   | Required | Constraints                                     |
| :--------- | :----- | :------- | :---------------------------------------------- |
| `username` | string | Yes      | Can be **username or email**, must not be blank |
| `password` | string | Yes      | Must not be blank                               |

## Authentication

⚠️ **Note**:  
Due to time constraints, JWT authentication was not implemented.  
Instead, **Basic Authentication** is currently used.  

This is **not recommended for production environments**, especially for web applications.  
In a real-world scenario, JWT or OAuth2 should be implemented to ensure proper security.

