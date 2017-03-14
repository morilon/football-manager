./gradlew --stop
./gradlew build
./gradlew :football-manager-store-teams:bootRun &
./gradlew :football-manager-store-matches:bootRun &
./gradlew :football-manager-service-teams:bootRun &
./gradlew :football-manager-service-matches:bootRun