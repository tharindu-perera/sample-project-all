FROM java:8
COPY ping.java /
RUN javac ping.java
EXPOSE 8085
ENTRYPOINT ["java"]
CMD ["ping"]