Feature: method GET streams
   Scenario: Verify the name of a stream
     Given I want to do GET request for the resource "/streams"
     When  I want to do GET request for the ID "3" and the name "Coding Stream"
     Then  I should be able to see the stream "Coding Stream"

   Scenario: Verify a list of streams
     Given I want to do GET request for the resource "/streams"
     Then  I should be able to see the titles of the streams "Come here boy! ", "Coding stream", ":O", "EVEN MORE NEW EMOTES | CODE: CHAP | !vid !code !socials",  "hehe ", "Tfault Squad Scrims w/ Vivid, Bizzle, & ZexRow"

   Scenario: Verify the response of the operation GET with parameters
     Given I want to do GET request for the resource "/streams"
     Then  I should be able to verifiy the Query parameter for the operation "1"






