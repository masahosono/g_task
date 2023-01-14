# g_task

独自コインの管理API（デモ）

## 動作環境
- macOS Ventura 13.0.1
- java17

## 導入手順

### データベース（mysql）

#### インストール
```shell
$ brew install mysql
```
```shell
$ mysql --version
mysql  Ver 8.0.31 for macos13.0 on x86_64 (Homebrew)
```

#### データベースの作成
```shell
$ mysql -u root
 
mysql> CREATE DATABASE gtask_db;
Query OK, 1 row affected (0.01 sec)
```

#### 接続設定をシステムの環境変数に設定
```shell
$ export SPRING_DATASOURCE_URL=jdbc:mysql://localhost:3306/gtask_db
$ export SPRING_DATASOURCE_USERNAME=[username]
$ export SPRING_DATASOURCE_PASSWORD=[password]
```

### アプリケーション起動
```shell
./gradlew bootRun
```