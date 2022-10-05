FROM python:3.10-slim-bullseye

RUN apt-get update \
    && apt-get -y install locales \
    && localedef -f UTF-8 -i ja_JP ja_JP.UTF-8

COPY main.py requirements.txt .
RUN pip install --upgrade pip &&\
    pip install --upgrade setuptools &&\
    pip install -r requirements.txt

CMD [ "python", "main.py" ]