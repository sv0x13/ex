from http.server import HTTPServer, CGIHTTPRequestHandler
import os, sys

web_dir = '.'
port = 80

os.chdir(web_dir)

srv_addr = ('',port)
srv_obj = HTTPServer(srv_addr, CGIHTTPRequestHandler)

srv_obj.serve_forever()
