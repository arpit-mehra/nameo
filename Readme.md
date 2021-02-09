## Name-O

This application provides an API to generate a unique pronounceable combination of words. 
You could use this for any purpose, or just for fun (keep refreshing and you will encounter something that makes you giggle !).
Some use cases are - 
1. Unique usernames for your application


It currently has just one endpoint - `http://localhost:8080/{size}`.
The `size` parameter is optional and if you do not provide, it uses the default value as 2 and generates a 2 word response.
The first is a verb, and the second is a noun. 
As you go from 2 to 4 values (which is currently the max value), it adds an adjective.
