# FoxProject
1. Project
-src
  com.fox.helper
    ExcelReadWrite.java
    Helper.java
  com.fox.shows
    LoginToShows.java
    AllFoxTabs.java
    DuplicateFinder.java
  com.fox.testcases
    FoxTestCases.java
    
 Output: foxshows.xls
 
com.fox.shows package : Code in this package goes to the fox website, sign in, lands on fox homepage, clicks on "Shows" then FOX, scrolls down, reads the last 4, goes to all the other tabs of fox and finds duplicates.

com.fox.helper package : This has helper class and ExcelReadWrite to write on to excel file.

com.fox.testcases : The file has all the test cases to run.

2. Running the code.
Run the  FoxTestCases.java file after saving the project in the above mentioned format.

3. As this was a small project with limited tests to run on a page, I created a class for all fox tabs instead of creating a class for each tab seperately. This removes a lot of redundancy and also scable for other projects.

 






