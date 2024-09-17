# Sử dụng một image Java chính thức
FROM openjdk:17-jdk-alpine

# Tạo thư mục cho ứng dụng
VOLUME /tmp

# Chỉ định thư mục làm việc
WORKDIR /app

# Sao chép thư mục lib và config vào container
COPY target/lib lib/
COPY target/config config/

# Sao chép file JAR từ thư mục target vào container
COPY target/account-service.jar account-service.jar


# Chạy ứng dụng
ENTRYPOINT ["java","-jar","account-service.jar"]