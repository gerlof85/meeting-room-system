Feature: Rooms require a location and capacity. Optional they have a name and facilities.


Scenario: Room can be found by location
Given a set with rooms has been imported
When requesting room with location "1.08"
Then the room with name "Rotterdam" should be returned by service