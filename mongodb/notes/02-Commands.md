## Commands

  

![[MongoDB-1.pdf]]

  

![[MongoDB-2.pdf]]

### Basic mongoDB :

|   |   |
|---|---|
|Command|Descreption|
|`db`|show the name of current database|
|`show dbs`|shows all database|
|`show collections`|show all collections in current databse|
|`use dbName`|switch to dbName database, created new if does not exists.|
|`cls`|clear terminal|

### Create :

- `db` points to current database
- Syntax :

```Plain
db.collectionName.methodName()
```

|   |   |
|---|---|
|Method|Descreption|
|`insertOne(data, option)`|Insert one document / row. <br>it creates collection if does not exists.|
|`insertMany( [{},{},{}] )`|Insert multiple document / row. <br>it creates collection if does not exists.|

### Read :

- Syntax :

```Plain
db.collectionName.methodName()
```

|   |   |
|---|---|
|Method|Descreption|
|`find()`|display all Document / Raw from collection.|
|`find(filter-obj,projection-obj)`|Find all matching in documnet.<br>Ex. `find({name:"viral"})`|
|`findOne(filter-obj,projection-obj)`|Find first matching in documnet.|

### Update :

- Syntax :

```Plain
db.collectionName.methodName()
```

|   |   |
|---|---|
|Method|Descreption|
|`updateOne(filter-obj, newValue-obj)`|update value<br>Ex. updateOne( { name:"viral"}, {$set : { name:"viral gajera"}} )|
|`updateMany((filter-obj, newValue-obj))`||

### Delete :

- Syntax :

```Plain
db.collectionName.methodName()
```

|   |   |
|---|---|
|Method|Descreption|
|`deleteOne(filter-obj,options)`||
|`deleteMany(filter-obj,options)`||
|`drop()`|To delete collection|

### Filter :

|   |   |   |
|---|---|---|
|Operator|Descreption|Example|
|`$lt`|less than|`{ price:{$lt:500} }`|
|`$lte`|less than, or equals||
|`$gt`|greater than|`{ price:{$lt:500}, rating:{$gt:4.5} }`|
|`$gte`|greater than, or equals||
|`$eq`|equals||
|`$ne`|not equals||
|`$in`|in <br>{ key: {$in: [array of values] } }||
|`$nin`|not in||
|`$and`|and <br>{ $and: [ { }, { } ] }|`$and : { price:{$lt:500}, rating:{$gt:4.5} }`|
|`$or`|or||
|`$set`|setting new value|`{name:"viral"},{$set : {name:"viral gajera"}}`|

Examples :

```Plain
db.users.find({age:{$lt:18}}, {name:1})        //    {name:1} projection object
```