Instructions related to code quality.

0. Do not put any compiled/generated files in the repository.

1. Do not put external files in the repository.
Ex: jquery, Jetty etc.
If you need to download some files to run the project, create a get_ext.sh to download them.

2. Images can be put in repository if they are a part of the application. Any image that qualify as input image should be not put in repository.

3. Follow coding guidelines and conventions.

4. Always test your code before committing them. Main branch should not be broken under any circumstances.

5. As a general rule do not use a pre-release dependency.
Ex: 
0.9.3 - Bad
0.2.0 - Worse
1.0.0 - Okay but wait for 1.1.0
4.5.3 - Very good