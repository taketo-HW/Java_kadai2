### java 基本構文の練習用のリポジトリ

1. このリポジトリを研修用のフォルダにクローンする

```
git clone https://github.com/YuYoshida7211/java-basic.git
```

2. docker コンテナを立ち上げる

```
// dockerビルド
docker-compose build

// dockerをバックグラウンドで起動
docker-compose up -d

// dockerコンテナに入る
docker-compose exec java bash

```

3. コンパイルと実行

```
// コンパイル
root@5b7be900c329:/usr/src# javac Main.java

// 実行
root@5b7be900c329:/usr/src# java Main
↓実行結果
Hello World!
```

研修の構文をコンパイルして確認してみましょう。
