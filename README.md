[![Build Status](https://travis-ci.org/gerlof85/meeting-room-system.svg?branch=master)](https://travis-ci.org/gerlof85/meeting-room-system)

# README #

Dojo Java: meeting room reservation system (mrrs)


### What is this repository for? ###

* create an application for making reservations for meeting rooms

### Scanarios ####

Feature: see available rooms
- Given user wants to know if there are rooms available at <time>
- When user requests available rooms
- The he gets an overview of the available rooms

Feature: display rooms with facilities
- Given user needs a room with a beamer
- When user requests rooms
- Then he gets an overview with rooms that have a beamer

Feature: make reservation
- Given user wants to make reservation
- When user chooses a room for reservation
- Then the selected room is assigned to user for <time>


### Todo ###  (/ means: basic setup is included)
- [x] Write user scenario's
- [x] Facility
- [x] Room
- [x] RoomRepository
- [x] csvRoomRepository (converts comma separated into roomrepo which contains rooms and facilities within rooms 
- [x] selenide test with static rooms overview web page (runs with Jetty)
- [ ] dynamic rooms overview web page, based on csv input
- [ ] csv file reader
- [/] selenide implementation
- [ ] something for adding a reservation