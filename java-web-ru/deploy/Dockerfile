FROM gradle:7.5.1-jdk17

WORKDIR /app

COPY / .

RUN gradle installDist

CMD ./build/install/deploy/bin/deploy