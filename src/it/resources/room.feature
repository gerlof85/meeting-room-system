Feature: Rooms require a location and capacity. Optional they have a name and facilities.


Scenario: Room can be found by location
Given a room with name "Berlin", location "1.12" and capacity 12 
    And which has facility "whiteboard"
When searching for room with location "1.12"
Then the room with name "Berlin" should be returned