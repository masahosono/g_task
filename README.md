# g_task




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

### システムの環境変数を設定
```shell
$ env | grep SPRING_DATASOURCE
SPRING_DATASOURCE_URL=jdbc:mysql://localhost:3306/gtask
SPRING_DATASOURCE_USERNAME=
SPRING_DATASOURCE_PASSWORD=
```


### アプリケーション起動
```shell
./gradlew bootRun
```