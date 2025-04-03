# ScheduleDevelop

![Java](https://img.shields.io/badge/Java-100%25-blue)

## 📌 프로젝트 소개
**ScheduleDevelop**는 Java로 개발된 프로젝트로, 로그인, 사용자가 일정을 추가, 수정, 삭제, 목록을 조회하고 일정 관리 기능을 구현하고 있습니다.

## 🛠 기술 스택
- **프로그래밍 언어**: Java
- **빌드 도구**: Gradle
- **버전 관리**: Git

## 🗂 디렉토리 구조
scheduledevelop/ ├── gradle/ ├── src/ │ ├── main/ │ │ ├── java/ │ │ └── resources/ │ └── test/ │ ├── java/ │ └── resources/ ├── .gitattributes ├── .gitignore ├── README.md ├── build.gradle ├── gradlew ├── gradlew.bat └── settings.gradle

## 🚀 주요 기능
- 일정 추가: 새로운 일정을 등록할 수 있습니다.
- 일정 수정: 기존 일정을 수정할 수 있습니다.
- 일정 삭제: 등록된 일정을 삭제할 수 있습니다.
- 일정 조회: 모든 일정을 목록 형태로 조회할 수 있습니다.

## ⚙️ 실행 방법
1. **프로젝트 클론**
   ```bash
   git clone https://github.com/sanghyeon0914/scheduledevelop.git
   
Gradle을 사용하여 빌드 및 실행

cd scheduledevelop
./gradlew build
java -jar build/libs/scheduledevelop.jar

