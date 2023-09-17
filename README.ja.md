# ReportGenerator

HTML、PDF、テキスト形式でレポートを簡単に出力できるWebアプリケーションです。
Java、Spring Boot、Next.js、TypeScriptあたりの技術を使いつつ、StrategyやBuilderといったデザインパターンもしています。

## 説明

ReportGeneratorを使用すると、タイトルやサブタイトルなどの内容を入力し、"Generate Report"ボタンをクリックするとtxtまたはhtml形式でのダウンロードが可能です。

## 実装されているデザインパターン

- **Strategyパターン:** HTMLやテキストなど、異なるレポート出力形式の間でシームレスに切り替えるために使用。
- **Builderパターン:** 特にフロントエンドからの多数のパラメータが関与する場合に、オブジェクトの作成を効率的に管理。

## 技術スタック

以下の技術を使用して構築:
- Java
- Spring Boot
- Next.js
- TypeScript

## 使用されているライブラリとツール

このプロジェクトでは、次のライブラリとツールを使用しています:

- Gradle - [公式サイト](https://gradle.org/)
- Spring Boot (バージョン 3.1.3) - [公式サイト](https://spring.io/projects/spring-boot)
- JUnit 5 (バージョン 5.9.1) - [公式サイト](https://junit.org/junit5/)
- TypeScript (バージョン 5.2.2) - [公式サイト](https://www.typescriptlang.org/)
    - このライブラリはApache License 2.0のもとでライセンスされています。
