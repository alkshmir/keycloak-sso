import os
from flask import Flask
from werkzeug.routing import Rule

app = Flask(__name__)

# setting base url
if os.getenv("BASE_URL"):
    BASE_URL = os.getenv("BASE_URL")
    print("BASE_URL is ", BASE_URL)
    # define custom_rule class
    class Custom_Rule(Rule):
        def __init__(self, string, *args, **kwargs):
            # check endswith '/'
            if BASE_URL.endswith('/'):
                prefix_without_end_slash = BASE_URL.rstrip('/')
            else:
                prefix_without_end_slash = BASE_URL
            # check startswith '/'
            if BASE_URL.startswith('/'):
                prefix = prefix_without_end_slash
            else:
                prefix = '/' + prefix_without_end_slash
            super(Custom_Rule, self).__init__(prefix + string, *args, **kwargs)

    # set url_rule_class
    app.url_rule_class = Custom_Rule
else:
    print("No BASE_URL is specified.")

@app.route('/hello')
def hello():
    return 'hello from flask!'

if __name__ == "__main__":
    app.run(host="0.0.0.0", port=5000)