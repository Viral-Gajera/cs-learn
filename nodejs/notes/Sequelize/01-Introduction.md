Installation

Important Function & Return values

  

- Sequelize is an open-source ORM (Object Relational Mapping) for Node.js.
- It allows JavaScript developers to work with relational databases, such as MySQL, PostgreSQL, SQL Server, Postgres, Oracle, MariaDB, SQLite, and more.

  

# Installation

```Shell
npm install --save sequelize sequelize-cli

# Driver - One of the following:
$ npm install --save mysql2       # SQL
$ npm install --save pg pg-hstore # Postgres
$ npm install --save tedious      # Microsoft SQL Server
$ npm install --save oracledb     # Oracle Database
$ npm install --save mariadb
$ npm install --save sqlite3
```

  

  

# Important Function & Return values

```JavaScript
await User.findAll({})
-> [{}, {}]                // Array of records

await User.findOne({})
-> {}                      // Object, that satisfy the condition. null otherwise

await User.create({})
-> {}                      // Object, inserted record 

await User.update({}, {})
-> [1]                     // Array of number of record update

await User.destroy({})
-> 1                       // number of record detected

build()
set()
await save()
await reload()
```