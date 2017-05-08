-- phpMyAdmin SQL Dump
-- version 4.5.0.2
-- http://www.phpmyadmin.net
--
-- Host: localhost
-- Generation Time: Apr 06, 2016 at 11:40 AM
-- Server version: 5.5.47-0ubuntu0.14.04.1
-- PHP Version: 5.5.9-1ubuntu4.14

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Database: `vaividhya`
--

-- --------------------------------------------------------

--
-- Table structure for table `events`
--

CREATE TABLE `events` (
  `id` int(10) NOT NULL,
  `name` text NOT NULL,
  `time` text NOT NULL,
  `type` text NOT NULL,
  `tag` text NOT NULL,
  `location` text NOT NULL,
  `intro` text NOT NULL,
  `task` text NOT NULL,
  `rule` text NOT NULL,
  `share_link` text NOT NULL,
  `co1_name` text NOT NULL,
  `co1_email` text NOT NULL,
  `co2_name` text NOT NULL,
  `co2_email` text NOT NULL,
  `last_update` text NOT NULL,
  `last_poster_update` text NOT NULL,
  `color_code` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `events`
--

INSERT INTO `events` (`id`, `name`, `time`, `type`, `tag`, `location`, `intro`, `task`, `rule`, `share_link`, `co1_name`, `co1_email`, `co2_name`, `co2_email`, `last_update`, `last_poster_update`, `color_code`) VALUES
(1, 'C Programming', '12:00 pm to 2:00 pm', 'Computer', 'An event of C Programming', '(Round - 2) in Lab 217-A', 'Event is distributed in two Groups.\n1. Computer & IT :- (1st and 2nd year) AND All other branches :- (1st, 2nd, 3rd and   4th year).\n2. Computer & IT :- (3rd and 4th year).', 'There will be 2 Round in this Event.\n1. Round 1 - Error finding and correction round.\n2. Round 2 - A problem given by coordinator.\n1. Note:- Evaluation includes time taken to solve problem\nas well as logic level of student. Problem statements ask as per student group level.', 'Student can participate either individual or in group of two.\nStudent must carry their Institute I-CARD and show it when coordinator ask to do so. Student not having valid I-CARD are not allowed in any case .\nStudent must sign in attendance sheet.(i.e. LAB)\n\nIn any situation decision of event faculty coordinator willbe final."', 'http://vaividhya.ssasit.org/department-wise-events/computer-engineering/c-programming.aspx', 'Bajariya Heena ', 'heenabajariya002@gmail.com', 'Mangroliya Kinna', 'kinnamangroliya@gmail.com', '1445926889610', '1420939064807', 10),
(2, 'CQuiz', '9:30 am to 12:30 pm', 'Computer', 'A C Quiz event', '(Round - 3) in room 310', '"Event is distributed in two Groups.\n1. Computer & IT :- (1st and 2nd year) AND All other branches :- (1st, 2nd, 3rd and   4th year).\n2. Computer & IT :- (3rd and 4th year).', 'General Rules .....\n\nRound 1 : \n(mcq without negative marking)\nTime : 60 minutes\nQuestions : 55\n\nRound 2 : \n(mcq with negative marking)\nTime : 45 minutes\nQuestions : 45\n\nRound 3:\n(buzzer round)\noptional question related to c lang.\nTime : 1:30 hour', 'Student must carry their Institute ICARD and show it when invilator ask to do so .\nStudent not having valid ICARD are not allowed in any case(Event fee Not refunded ).\nStudent must sign in attendence sheet In event place(Ie.LAB)."', 'http://vaividhya.ssasit.org/department-wise-events/computer-engineering/cquiz.aspx', 'Motisariya Nirali ', 'niralimotisariya102@gmail.com', 'Patel Krupa', 'patelkrupa1050@gmail.com', '1424309759737', '1420939764888', 2),
(3, 'Sagkirna', '9:00 am to 11:00 am', 'Computer', 'The hidden secrets', '(Round - 2) in room 311-312', 'No specific cryptography algorithms are needed to be learned. Just bring your brain, use it and enjoy the world of finding encrypted message.', 'Usage of any external media is not allowed.\nDiscussion should be restricted to within team only.\nAll required hints will be given in paper. Rest hints are be fetched applying brain\nIt is a 2 round event.\nAny sort of Discussion with other team(s) will lead to disqualification of team(s).', 'Just get a pen/pencil with you and your brain to work on the sheet.\nEnough space will be provided on sheet for calculations. No extra sheet will be provided and is not at all required during the event.\nQualification in first round for second round will be based on correctness of answer decoded and time used to do so.\nFollow rules to have extreme fun.', 'http://vaividhya.ssasit.org/department-wise-events/computer-engineering/sagkirna.aspx', 'Lukhi Vivek', 'vvk023@gmail.com', 'Hirapara Priyanka', 'patelpiyuh31@gmail.com', '1424309801665', '1420940357530', 2),
(6, 'Hunt Roadies', '9:30 am to 6:00 pm', 'General', '', ' in room 206-207-208', 'Use your mind and strength to prove yourself as Roadie . The event is full of fun, challenges and brain work. Come prepare to win.', 'Individual entries are allowed.\nGroup will be formed by event coordinator later on.\nThere will be 4 rounds based on physical and metal task including clues.\n\n', 'Coordinators or team will not be responsible for any injury of participant.\nAny act of misbehavior or misconduct will lead to immediate disqualification of the team.\nIn case of any conflict, the final decision will be of jury members & organizers.', 'http://vaividhya.ssasit.org/department-wise-events/general-events/hunt-roadies.aspx', 'Sojitra Shani', 'huntroadies3@gmail.com', 'Rushik Ramoliya', 'huntroadies3@gmail.com', '1423915917398', '1421065608110', 3),
(7, 'Five Pixel Story', '10:30 am to 11:30 am', 'General', '', 'in room 304', 'no intro', 'Candidate has to submit 5 pictures which create one story.\nCandidate Have to submit other picture image which prove that other five picture was taken by you. \n', 'Candidate can''t   use collage.\n Five pictures have conveyed 1 story. Nearest one announce as winner.', 'http://vaividhya.ssasit.org/department-wise-events/general-events/five-pixel-story.aspx', 'Chinmay patel', 'chinmay.patel1994@gmail.com', 'Vachan prajapti ', 'nomail', '1423972613371', '1421065825790', 9),
(8, 'Movie Making', '10:30 am to 11:30 am', 'General', '', 'in room 304', 'no intro', 'Teams must register minimum 48 hours before start of the competition.\n\nThe finished film must be a minimum of 1 minute in duration and a maximum 8 minutes in duration.\n', 'Teams must register minimum 48 hours before start of the competition.\nTeam must be group in minimum 2 and maximum 7 number of persons.', 'http://vaividhya.ssasit.org/department-wise-events/general-events/movie-making.aspx', 'Chinmay Patel ', 'noemail', 'Vijay Rathod', 'noemail', '1423972639226', '1421065990120', 9),
(9, 'Quiz On SSASIT', '11:30 am to 5:30 pm', 'General', '', 'in room 305', 'Come let us know how much you know SSASIT.\nThe quiz will be purely based on details, statistics, and information of SSASIT or any individual related to SSASIT.\n\nThe questions can range from:\n   1.When was SSASIT established?\n   2.Who is the current Incharge principal of SSASIT?\n   3.What is the lab number of TOM/DOM lab?\n   4.Which floor is the Humanities and Social Science Department?\n   5.What is the name of institute''s magazine?\nf you love your SSASIT you will definitely be a part of this.\n', 'Only single participant per entry.\nIt is a 2 round quiz.\nFirst round will be objective type questions.\nSecond round might have descriptive type question.\nOnly qualifier of first round will go to second round.\n', 'Discussion during exam is not allowed.\n\nNo use of electronic device is allowed during exam.\n\nAnswer key will be provided after entire event completes but no clarification regarding answers will be given.\n\nCLOSE\nHints for quiz:\n\nVisit ssasit.org website thoroughly.\nVisit the infrastructure of SSASIT, make note of room numbers, persons related to SSASIT specially teaching and non-teaching staff.', 'https://docs.google.com/spreadsheets/d/1KnU4MW5xGx9j9DFDRfwawcz_ldFLSL58ntPoz1p_oNA/edit#gid=1509538448', 'Prof. Akhilesh Ladha', 'ladhaakhilesh@gmail.com', 'no', 'no', '1423916520628', '1421066877953', 7),
(10, 'Find Follower', '9:30 am to 6:00 pm', 'General', '', '[Ground]', 'no', '4 members in one team.\nRobot should operate on battery power not electrical supply.(use only 12v dc battery).\nThere are two rounds\nOut of two, in any one round operator has to cover his/her eyes with the help of black ribbon.', 'The teams will not get any time for practicing on the game field.\nNo repairing time will be given while your robot is damage or wiring problem on the game field.\nThe score measured by the co-ordinators will be final.\nCLOSE\nThe robot or the team members in any case should not harm the game field in that case the robot will be disqualified.', 'http://vaividhya.ssasit.org/department-wise-events/general-events/find-follower.aspx', 'Jagat Ahir', 'jagatkumarahir@gmail.com', 'Vaghasiya Sandip', 'no', '1423915674854', '1421074110149', 5),
(11, 'IQ Twist', '9:30 am to 6:00 pm ', 'General', '', 'in room 102', 'DO YOU THINK YOU HAVE AN ACUTE MIND...?\nARE YOU SMART...?\n\nThen this event is for you...stretch your brain, twist your brain and crack the challenges.\n\nAs its name suggest it is related to IQ. So it can be regarded as unique non technical event.\n\nAs an engineering point of view this event is related with logical, analytical skill and focus and team building skills.\n', 'Four members are allowed in a team\nAll the details about the rounds will be informed at the time of event.', 'Participants need to make sure that they reach the spot of event within the stipulated time, otherwise it may lead to the cancellation of their registration.\n4.Refund will not be provided once the group has registered themselves for the event.\n\n5.Any indiscipline will not be tolerated and all the decisions would rest in the hands of event-coordinator and branch-coordinator.', 'http://vaividhya.ssasit.org/department-wise-events/general-events/iq-twist.aspx', 'Gupta Premal', 'no', 'Sapariya Ramesh', 'no', '1423971457327', '1421074546726', 11),
(12, 'Mystery of Sherlock Holmes', '9:30 am to 6:00 pm ', 'General', '', 'in room 212', 'no', 'Only individual entries are allowed.\nGroup will be formed by event co-ordinator later on.\nThere will be four rounds based on mystery related to Sherlock Holmes.\nFirst round will be pre-event, Short listing of participants will be taken after first mandatory round.', 'Co-ordinators will not responsible for any injuries to participants during event.\nCLOSE\nIn case of any discrepancy, event co-ordinators decision will be final.', 'http://vaividhya.ssasit.org/department-wise-events/general-events/mystery-of-sherlock-holmes.aspx', 'Parimal Vala', 'parimalvala5022@gmail.com', 'Aman Makvana', 'no', '1423971489002', '1421074780565', 2),
(13, 'Wall Painting', '16 Feb 2015  9:30 to 11:30', 'General', '', '@SSASIT', 'no', 'Should not take help other members.\nParticipant have submit theme for wall painting before 10/02/2015 for verification after proper verification allowed theme for wall painting.\n\nTime limit for wall painting is 2 hrs.', 'Maximum 5 persons & minimum 2 persons allows in one group.\n\nMaterials which are used in wall painting are should bring by participates.', 'http://vaividhya.ssasit.org/department-wise-events/general-events/wall-painting.aspx', 'Balar Manisha', 'balarmani005@gmail.com', 'Rushmita Sutariya', 'rushmitapatel@gmail.com', '1421075211926', '1421075110393', 6),
(15, 'The Art', '19 Feb 2015 8:00 to 10:00 am', 'General', 'asd', 'asd', 'It is a competition in which painting should be paint on A3 size paper provided by our institute. Painting should be based on certain theme providing a social and positive message.', 'You have to convey some positive message in your Painting. On the topic like-save environment , Stop corruption etc.\n\nIn competition only drawing Page (A3 size) will be provide.', 'Only water & acrylic color painting will be allowed.]\n\nAll things required in painting should be brought by yourself. Like color, brush etc.\n\nFinal decision will be taken by co-ordinators.\nTime Duration is 2 hours\n\n', 'http://vaividhya.ssasit.org/department-wise-events/general-events/the-art.aspx', 'Ramoliya Rushik', 'rgramoliya006@gmail.com', 'Vasani Hardik', 'no', '1421075900892', '1421075901142', 10),
(16, 'Darkness of Devil', '9:30 am to 6:00 pm ', 'General', '', 'in room 107', 'no', ' there will be a dark room. this adventurer room include skull, skeleton, water bridge, grass land, scary thing, adventurer things,\n\ngrass window, any many more. it also include dead body, hanging man, soul and devil with horror things.\n\nparticipant find the devil and end the game\n\nparticipant who finds the devil within the given time limit, the fees will be refunded back* \n', '1) strictly prohibited this things,\n\n    shoes or slipper, mobile phone, battery light and your mis-behaviour\n\n2) one participant participate at time\n3) time length of game is decied at date of vaividhya\n\n4) our battery light is provied if it''s necessary\n\n5) hangout man, ghost or any dead body will able to scare you, so do not argue or fighting with any person in the room\n\n6) do not damage the structure of "darkness of devil" game, otherwise strict action under goes', 'http://vaividhya.ssasit.org/department-wise-events/general-events/darkness-of-devil.aspx', 'Venish Goyani', 'venishgoyani@gmail.com', 'Hardik Pateliya', 'phardik014@gmail.com', '1423971732080', '1421076139275', 8),
(17, 'Circuit Solver', '2:30 pm to 5:30 pm', 'Electrical', '', '(Round - 1) in room 204-304', 'no', 'First written exam taken. top 5-6 groups select for next round.\nany circuit given to candidates.\n\nThe qualifiers and winners will be selected on the basis of less time took by the group for the desired output.', 'Any kind of helping materials will not be provided to the participants, and they are not allowed to bring their own materials. They have to complete the task only with the materials provided by the institute only.\n\nThere will be time limit for each level and no participants will be allowed extra time in any circumstances.\n\nThe qualifiers and winners will be selected on the basis of less time took by the group for the desired output.\n\nIf no participant gets the desired output then the winners will be decided on the basis of completion of circuit and time taken.', 'http://vaividhya.ssasit.org/department-wise-events/electrical-engineering/circuit-solver.aspx', 'Mendapara Jainish', 'jainishm95@gmail.com', 'Mistri Krutika', 'mistrikrutika@gmail.com', '1423971779797', '1421076393154', 9),
(18, 'Model Presantation', '10:30 am to 1:30 pm', 'Electrical', '', 'in Machine lab-006', 'no', 'Candidates presents their working model based on any subject related to engineering.\njury select the winner based on model and presentation of it.', 'ach team should consist maxi. 3 members.\nIt is compulsory for each member of team to carry their respective i-card.\nach team should consist maxi. 3 members.\nIt is compulsory for each member of team to carry their respective i-card.', 'vaividhya.ssasit.org/department-wise-events/electrical-engineering/model-presantation.aspx', 'Patel Vishrut', 'vishrutpatel95@yahoo.com', 'Jani Milankumar', 'mjani38@gmail.com', '1423971825258', '1421077048658', 11),
(19, 'Paper Presentation', '9:30 am to 2:30 pm', 'Electrical', '', 'in room 306', 'no', 'Candidates present their paper(PPT) related to electrical branch.\njury will decide the winner based on Candidates Technics or methods for presenting their paper.(PPT)\n', 'Maximum two students per group can present a paper.\nOverhead Projector, Multimedia Projector, Slide Projector or Direct Projector will be provided.\nPresentation time is 10 min. & 5 min. for question-answer round.\nPaper should not exceed 10 pages excluding title pages, page size being ''A4'', one side printing, single spacing and ''TIMES NEW ROMAN'' with font size 12.\nCandidates have to submit\nOne hard copy\nOne soft copy through E-mail\nCLOSE\nEvent''s name and Category should be described.', 'vaividhya.ssasit.org/department-wise-events/electrical-engineering/paper-presentation.aspx', 'Bhadresh bhikadiya', 'bhdresh885@gmail.com', 'Oves mirza', 'ovemirza@icloud.com', '1423915420744', '1421077856262', 3),
(20, 'Poster Presentation', '2:30 am to 6:00 pm', 'Electrical', '', 'in room 211', 'no', 'Candidates presents their poster.\nJudging criteria for poster presentation will be topic of poster,explanation,design of poster and your knowledge of that topic.\n', 'Each team should consist maximum of 2 members.\nIt is compulsory for each member of the team to carry their respective I-Cards.\n"" Maximum size of poster allowed is A1""\n\nTable for the poster presentation will be provided at our college premises.\nJudging criteria for poster presentation will be topic of poster,explanation,design of poster and your knowledge of that topic', 'http://vaividhya.ssasit.org/department-wise-events/electrical-engineering/poster-presentation.aspx', 'Nikita', 'nikitamangukiya@gmail.com', 'Jain Karishma', 'jain.jain.k@gmail.com', '1423971865306', '1421078630830', 6),
(21, 'Watts Right', '12:30 pm to 2:30 pm', 'Electrical', '', '(Round - 1) int room 310', 'quiz type event.', 'Participants are allowed to make a group of maximum 3 members in each team.\nAll the team members are permitted to give the entrance exam collectively.', 'During the entrance test if any group member found with any unfair means then the whole team will be disqualified.\n\nThere will be no negative scoring\n\nStudents will be not allowed to speak the answers unless the question is passed to them, and if any team found violating this rule a deduction in their score can be done by the authorities.\n\n', 'vaividhya.ssasit.org/department-wise-events/electrical-engineering/watts-right.aspx', 'Patel Kishan', 'kp12531@gmail.com', 'More Aditya', 'kp12531@gmail.com', '1423972036649', '1421078888539', 0),
(22, 'Robo Race', '9:30 am to 6:00 pm', 'Electrical', '', '[Ground, Tent]', 'no', 'Winners selected base on less time consisting by robot with given track for race.', 'Each team should consist maximum 2 members.\n\nIt is compulsory for each member of the team to carry their respective\ni-card.\n\nThere will be negative scoring considering at every touch of robo to the line.\n\nNumber of two teams will be play at same time as an opposition of each other.\n\nBettery voltage of robo is less than 12 volt.', 'http://vaividhya.ssasit.org/department-wise-events/electrical-engineering/robo-race.aspx', 'Mangukiya Ankitkumar', 'ankitmangukiya34@gmail.com', 'Kumbhani Bhavesh', 'kumbhanibhavesh@yahoo.in', '1423972066879', '1421079168776', 11),
(23, 'Laser Maze', '9:30 am to 6:00 pm', 'Electrical', '', 'in room 209', 'Puzzle type event.', 'Numbers of mirrors and lasers are given by game co-coordinator for solve the puzzle.\ntwo spot will given one spot is ""from where to though laser light""\nsecond spot is ""from where to collect the light"" through the mirror, obstacles are there between two spot which described.\n', 'Each team should consist maximum 3 members.\n\nIt is compulsory for each member of the team to carry their respective i-card.\n\nNumbers of mirrors and lasers are given by game co-ordinator.', 'http://vaividhya.ssasit.org/department-wise-events/electrical-engineering/laser-maze.aspx', 'Ghelani Hiral', 'hina.ghelani004@gmail.com', 'Chinmay', 'chinmay.patel1994@gmail.com', '1423972085679', '1421079337768', 1),
(24, 'Robo Goal', '9:30 am to 1:30 pm', 'E&C Engineering', '', '(Round - 1) [Ground]', 'no', 'Robotics football game.\ntwo team with their robot on stage and they have to defend their goal-pose.\none team who scored more then opposition will be a winner.', 'Each team should consist maximum 2 members.\nIt is compulsory for each member of the team to carry their respective i-card.\n\nThere will be negative scoring considering at every touch of robo to the line.\n\nNumber of two teams will be play at same time as an opposition of each other.\nBettery voltage of robo is less than 12 volt.', 'http://vaividhya.ssasit.org/department-wise-events/electrical-engineering/robo-goal.aspx', 'Modi Vishal', 'vish.modi71@gmail.com', 'Sandip', 'sorathiyasandip752@gmail.com', '1423972124181', '1421079471794', 1),
(25, 'Niyantrak-E-Kunchika', '9:30 am to 10:30 am', 'Ec', '', '(Round - 1) in room 107', 'no', 'There will be 3 rounds.\n\n    Test Round\n    Code debugging  Round\n    Programming  Round\n\nIn Test round, there will be a simple  MCQ test based on  8051 Microcontroller.(1 hour)\n\nIn Code Debugging  round, team will be given an error containing program and team will have to correct the error.(45 min)\n\nIn Programming round, qualified team will be given a program definition and they will have to make a correct program and will have to conduct the simulation.(1 hour)', 'for Rules visit vaividhya site', 'http://vaividhya.ssasit.org/department-wise-events/e-c-engineering/niyantrak-e-kunchika.aspx', 'Saraswat', 'deepikasaraswat111@gmail.com', 'Shah Kajal', 'kajalshah5905@gmail.com', '1423972160096', '1421087979327', 5),
(26, 'Bubble Blaster', '9:30am to 11:30am', 'Ec', '', '(Round - 1) [Ground, Tent]', 'Build a robot such that it can catch the water and complete the given track in least period of given time.', 'no', 'One team should have maximum 4 participants.\n\nEach team is allowed to have only one robot.\n\nThe robot with the mechanism must fit into a cube of dimensions 45 cm x 45 cm x 45 cm (L x B x H) and maximum weight of robot with controller and battery should not exceed 10 kg.\n\nRobot can expand after the game starts but expansion of the robot must not exceed 60 cm x 60cm x 60 cm (L x B x H).\n\nWired and Wireless robots are allowed.\n\nAll team will have to submit their robot to the respective coordinators before start of the event.\n\nParticipants will be responsible for any damage to robot caused by obstacles.\n\n', 'http://vaividhya.ssasit.org/department-wise-events/e-c-engineering/bubble-blaster.aspx', 'Chaudhary', 'niketchaudhary31@gmail.com,', 'thummar', 'kishan.thummar123@gmail.com', '1423915178378', '1421088222116', 4),
(27, 'Marg-Anuyayi', '2:30 pm to 5:30 pm', 'Ec', '', '(Round - 1) in room 109', 'Robot Should follow a path.', 'One team should have maximum 3 participants.\n\nEach team is allowed to have only one robot.\n\nThe track of the competition will be displayed on the notice board. The competition will have 2 rounds. In the 1st round the robots will have to follow the track as shown on the notice board. ', 'The teams selected further will be given a more advanced field at the time of the competition designed in a manner such that the robots following the track of the 1st round will be able to follow the final track also if coded properly.\n\nThe field will be white in background having black lines of width 3 cm on the flex banner.\n\nit will have small variations in the normal flow of line as shown in the notice board.', 'http://vaividhya.ssasit.org/department-wise-events/e-c-engineering/marg-anuyayi.aspx', 'Agrawal Hemant ', 'agrawalhemant5393@gmail.com', 'Priyanka Bari', 'priyankabari95@gmail.com', '1423972199116', '1421088443787', 1),
(28, 'Paper Presentation', '9:30 am to 2:30 pm', 'Ec', '', 'in room 408', 'no', 'Maximum two students per group can present a paper.\n\nOverhead Projector, Multimedia Projector, Slide Projector or Direct Projector will be provided.\n\nPresentation time is 10 min. & 5 min. for question-answer round.\n', 'Paper should not exceed 10 pages excluding title pages, page size being ''A4'', one side printing, single spacing and ''TIMES NEW ROMAN'' with font size 12.\n\nCandidates have to submit\n\nOne hard copy\nOne soft copy through E-mail\n\nfor complete visit vaividhya site.', 'http://vaividhya.ssasit.org/department-wise-events/e-c-engineering/paper-presentation.aspx', 'Maheta Shital', 'mahetashital@gmail.com', 'Avaiya Jimesha', 'januavaiya1432@gmail.com', '1423915447203', '1421089179482', 0),
(29, 'Playcard Praysent', '2:30 am to 6:00 pm', 'Ec', '', 'in room 211', 'Poster presentation is an event in which a team has to make a poster about any system. This event will create the ability for presentation skill. \n\nList of selected participants will be displayed on the website and selected poster will be presented before judges.', 'Topic of the poster should be related with the Electronics and Communication.', 'Maximum 3 persons are allowed in a group.\n\nParticipants have to use A1 size poster.', 'http://vaividhya.ssasit.org/department-wise-events/e-c-engineering/placard-praysent.aspx', 'Surbhi Sharma ', 'surbhisharma328@gmail.com', 'Sneha Lavishetti ', 'lavishettisneha@gmail.com', '1423971988672', '1421089437930', 6),
(31, 'Kretsmoron', '1:30 pm to 2:30 pm', 'Ec', '', 'in room 412', 'Let''s crack with some vandalisum...', 'Maximum 3 persons are allowed in a group.\n\nThere will be 2 rounds\n    1. Qualifying Round\n    2. Implementation Round\n\nIn Qualifying round, there will be a simple technical exam of MCQ.\nTime for the qualifying round will be 30 minutes and for the implementation round it will be 60 minutes.\n\nIn Implementation round, students of 1st& 2nd year will be considered in Part A and students of 3rd& 4th year will be considered in Part B.\n\nIn Part A, circuit diagrams will be provided. Participants will have to design, execute and explain circuit.\n\nIn Part B, the participants will be required to efficiently design a circuit based on the definition given to them.', 'Any damage in components given is responsible to team.\n\nAny act of misbehavior or misconduct will lead to immediate disqualification of team.\n\nIn case of any conflict, the final decision will be of jury members & organizers.\n\n-----Evaluation Criterion:-----\nBased on the time taken by team to get the output.\n\nPrecision of output will be considered in the result.\n\nIf no one completes the circuit then winner will decide by maximum completion of circuit and better work.', 'http://vaividhya.ssasit.org/department-wise-events/e-c-engineering/kretsmoron.aspx', 'Anghan Ankita ', 'kretsmoron@gmail.com', 'Patel Richa', 'no', '1423915232981', '1421090756107', 10),
(33, 'Model Expositio', '2:30 am to 6:00 pm', 'Civil', '', 'in room 211', 'Model presentation is an event in which a team has to represent any type of mechanism which is useful to interprete in , working or dummy condition of different engineering field.\n', 'Each team should consist max. 4 members.\nAREA FOR MODEL TO BE MADE \n\n1. Transportation Engineering.\n2. Urban Planning\n3. Advance transportation techniques.\n4. Sustainable urban planning.\n5. Advances in concreate technology.\n6. Advance or innovative structures.\n7. Green technologies.\n\n', 'for more details contacts coordinator or visit vavidhya site.', 'http://vaividhya.ssasit.org/department-wise-events/civil-engineering/model-expositio.aspx', 'Tariq Jagirdar ', 'tariq.jagirdar@gmail.com', 'Makwana', 'makwanaaman@gmail.com', '1423971883595', '1421091271883', 9),
(34, 'Model Factio', '18 Feb 2015', 'Civil', '', '@SSASIT', 'no', 'on the spot model making with provided material within givin time limit', '1.only 2 to 4 members are allowed in one group\n2.students can only use material provided by the institute\n\n3.if any student found using outside material will be disqualified.\n4.students have to complete model within given time limit.\n', 'http://vaividhya.ssasit.org/department-wise-events/civil-engineering/model-factio.aspx', 'Neel Vagadiya', 'njvagadia64@gmail.com', 'Abhishek Kathiriy', 'abhishekkathiriya@gmail.com', '1421118358592', '1421118358795', 6),
(35, 'Paper Expositio', '9:30 am to 2:30 pm', 'Civil', '', 'in room 208', 'no', 'Paper is presented in the form of word & PPT on the basis of civil engineering areas.\n\nPaper is to be presented on the basis of civil engineering areas.\n\nSubmit abstract of proposed paper on or before 27-01-2015.\n', 'Acceptance of abstract will be forwarded on or before 02/02/2015.\n\nTopics relevant to civil engineering are invited.\n\nMax. three students per group can present a paper.\nProjector for presentation will be provided.\n\nCandidates have to submit paper on or before 12-02-2015 through email to student coordinators of the event.\n\nCandidates have to bring hard copy of paper at a time of presentation. ', 'http://vaividhya.ssasit.org/department-wise-events/civil-engineering/paper-expositio.aspx', 'Purvesh Kakadiya', 'puresh.kakadiya23@gmail.com,', 'Rajen Dharia', 'dharia.rajen@gmail.com', '1423915585339', '1421118562959', 2),
(36, 'Technico Implico', '18 Feb 2015', 'Civil', '', '@SSASIT', 'no', 'Any practical situation regarding to civil engineering will be given to the participants and they have to solve it in fix duration.it will be conducted in three stages.\n', '1.only 3 candidates can participate in each group.\n\n2.No electronic gadgets can be allowed.', 'http://vaividhya.ssasit.org/department-wise-events/civil-engineering/technico-implico.aspx', 'Patel Falguni', 'falgupatel28@gmail.com', 'Patel Minal', 'patelminal241248@gmail.com', '1421118681832', '1421118681972', 4),
(37, 'Castio', '9:30 am to 12:30 pm ', 'Civil', '', '(Round - 1) int room 10', 'no', 'on the spot casting of any type of brick masonary wo', '1.maxi. 1 hour will be given to participants for casting.\n\n2.max. 5 persons per group are allowed.', 'http://vaividhya.ssasit.org/department-wise-events/civil-engineering/castio.aspx', 'Mehul Hisoriya', 'mehulhisoriya123@gmail.com', 'Rupapara Savan', 'savanrupapara744@gmail.com', '1423972284072', '1421118787477', 9),
(38, 'Fun Ferina', '9:30 am to 6:00 pm', 'Civil', '', 'in Girls Parking', 'no', 'Here you will get the fun by playing different unique games.', '1.The fun game will be played by individuals.\n2.No group entry will be allowed.\n\nStudent must keep their ID card during event.\n', 'http://vaividhya.ssasit.org/department-wise-events/civil-engineering/fun-ferina.aspx', 'Dhaval Isamaliya', 'samaliyadhaval@yahoo.com', 'Kinjal Mistry', 'mkinjal.1993@gmail.com', '1423972329848', '1421118909879', 7),
(39, 'Quaestio', '18 Feb 2015', 'Civil', '', '@SSASIT', 'no', 'There will be technical as well as general quiz ,the event is open for all branches.', '1.only 3 candidates can participate in each group.\n\n2.Do not allow mobile or other electronic instruments.\n\n3.Replacement of any participant of a team is not allowed after registration.', 'http://vaividhya.ssasit.org/department-wise-events/civil-engineering/quaestio.aspx', 'Raju Paladiya', 'rajpaladiya42@gmail.com', 'Advani', 'chintanadvani@gmail.com', '1421119021168', '1421119021371', 1),
(40, 'Musica Expressus', '18 Feb 2015', 'Civil', '', '@SSASIT', 'no', 'There will be total 5 extra ordinary rounds for making the musical express going on.\n', '1.song can''t be repeated.\n\n2.mobiles are not allowed.\n\n3.only bollywood songs are allowed.\n\n4.at least first verse of the song must be sing.\n\n5.If singer does''t remember entire link, they can''t be use that song.', 'http://vaividhya.ssasit.org/department-wise-events/civil-engineering/musica-expressus.aspx', 'Dhanani', 'poojadhanani280495@gmail.com', 'Payal Lunagariya', 'payalluna@gmail.com', '1421119120090', '1421119120324', 3),
(41, 'Optimum E Deserta', '18 Feb 2015', 'Civil', '', '@SSASIT', 'no', 'By using different types of waste material,one has to make best things.', '1.No materials will be provided from the college.\n\n2.Max. 3 candidate is allowed in each group.\n\n3.Max. 2 hours will be allowed to make a model.\n\n4.The prepared thngs are not allowed in the event.\n', 'http://vaividhya.ssasit.org/department-wise-events/civil-engineering/optimum-e-deserta.aspx', 'Shital Kakadiya', 'shitalkakadiya94@gmail.com', 'Krunali Mavani', 'krunalimavani@gmail.com', '1421119209588', '1421119209900', 2),
(42, 'The Machinist', '11:30 am to 3:30 pm', 'Mechanical', '', '(Round - 1) in room 008', 'A reprise edition of one of the successful events of last year''s techfest\n\nLet''s put your mind and body in the race by unity of group Solve the problems, generate the power and line the mechanism\n\nThis event is for a true ardent mechanical fan...', 'Rounds:                                                                                                                 1. BANG THE QR - solve the QR and make the assembly of machine.\n\n2. ENERGY GRID - produce the energy by developing the unique machine with maximum stability and power.\n\n3. MECH -a- LINE - develop the chain reaction between the mechanisms and develop complex machine witch can full fill the given task in minimum time \n\n[A group must carry a phone with application that reads the QR scanner ]', '1. A team can consist of 5 members at the most.\n\n2.  Any indiscipline within the campus or during the events may lead to the cancellation of your registration.\n\n3. All the equipments and mechanical parts to be provided needs to be handled with care. Any damage to them may invite the fine.\n\n4. All the decisions lies in the hand of event and branch coordinators.', 'http://vaividhya.ssasit.org/department-wise-events/mechanical-engineering/the-machinist.aspx', 'Daxesh Patel', 'daxesh.vaividhya@gmail.com', 'Sutaria Ankit ', 'aa.sutaria@gmail.com', '1423972383928', '1421154622408', 11),
(43, 'Robo Wars', '8:30 am to 10:30 am', 'Mechanical', '', '(Round - 1 & Round - 2) [Ground]', '"This is the event without which a techfest is incomplete.....Bring on your bots on the battlefield...destroy ..conquer...and be the ruler... Vaividhya brings you the ultimate battleship of robots...Lets fight it hard.."\n', '"Dimension :45*45*45 cm\n\nWeight : maximum 15 kg weight is allow on the stage. (Note: If battery is out of the stage then and then battery weight is not counted.)\n\nBattery limit : 12V,No ampere limit . (AC supply is not provided by college)', 'Maximum 5 people in the team.\n\nAt a time of match maximum 3 people are allow in ground.\n\nThe decision of jury is FINAL. If any kind of miss behaviour is found then the team will be disqualified.\n\nAfter registration, no refund would be provided.\n\nWire cutting is allowed in the match.\n\nOther rules will be explained at the time of match.\nAny kind of changes can be done by jury at the time of match.\n', 'http://vaividhya.ssasit.org/department-wise-events/mechanical-engineering/robo-wars.aspx', 'Vinay Zinzudiya', 'no', 'no', 'no', '1423914482753', '1421154824358', 10),
(44, 'Paper Presentation', '2:30 pm to 6:30 pm', 'Mechanical', '', 'in room 208', 'The main aim of Paper Presentation is to motivate the students and increase their confidence level, enhance their communication skills and express their technical knowledge through PAPER PRESENTATION.\n\n', 'Last date for abstract submission: 25/01/2015.\n\nPaper acceptance Notification : 30/01/2015\n\nLast date for final Paper submission: 10/02/2015\n\nSend your Abstract to:: kuldeeppolra31@live.com\n', 'Maximum two students per group are allowed to present a paper.            \n\nIt is compulsory for each member of the team to carry their respective college I-Cards.\n\nOverhead Projector, Multimedia Projector, Slide Projector or Direct Projector will be provided.\n\nvisit  vaividhya site for complete details.', 'http://vaividhya.ssasit.org/department-wise-events/mechanical-engineering/paper-presentation.aspx', 'Chintan Dhola', 'chintandhola@gmail.com', 'Kyada Vishal', 'no', '1423972420183', '1421155317185', 11),
(45, 'Model Presentation', '2:30 am to 6:00 pm', 'Mechanical', '', 'in room 102', 'Model presentation'' is an event in which a team has to create or represent any types of mechanism or general useful interpretation in working or dummy condition of different engineering field.', 'no', '1. Each team should consist of 3 members at the most.\n\n2. It is compulsory for each member of the team to carry their respective college I-Cards.\n\n3. It is compulsory for each member of the team to carry their respective i-card.\n\n4. Atleast 2 members of the team should be from the mechanical branch.\n\n5. Each team will have maximum of 10 minutes to explain about their model.', 'http://vaividhya.ssasit.org/department-wise-events/mechanical-engineering/model-presentation%28mech%29.aspx', 'Vaghasiya Piyush', 'piyushvaghasiya162@gmail.com', 'no', 'no', '1423971914899', '1421155483525', 4),
(46, 'Poster Presentation', '18 Feb 2015', 'Mechanical', '', '@SSASIT', '"Poster Presentation" is an event in which a team has to make a "Poster" about any company or any system . Poster gives information about any organization and system and a team gives presentation  according to the poster.   \n', 'no', '1. Each team should consist of 2 members at the most.\n\n2. It is compulsory for each member of the team to carry their respective college I-Cards.\n\n3. Maximum size of poster allowed is A1.\n\n4. The team will get 10 minutes to explain their poster. (5)Topic should be relevant to the mechanical field.', 'http://vaividhya.ssasit.org/department-wise-events/mechanical-engineering/poster-presentation%28mech%29.aspx', 'Ahir Rajesh', 'aj5366esh@gmail.com', 'Dudhat Chirag', 'no', '1421155686834', '1421155686085', 1),
(47, 'M.A.D.', '10:30 am to 11:30 am', 'Mechanical', '', '(Round - 1) in room 113-114', 'It is a pure mechanical event checking your reasoning skills and the design ability in making a working model of a vehicle and engine.', 'Top three teams will be competing in the final.\n  1-MECHYPEDIA\n  2- AMPHIBIAN MACHINE\n  3-STEAM OF WATT', '1. Four members are allowed in a team\n\n2..All the details about the rounds will be disclosed at the time of event.\n\n3.Participants need to make sure that they reach the spot of event within the stipulated time, otherwise it may lead to the cancellation of their registration.\n\n4.Kit for the last two rounds will be provided at the time of event.\n\n5.All the working tools provided should be handled with care. Any damage to them may invite the fine.\n\n6.Refund will not be provided once the group has registered themselves for the event.\n\n7.Any indiscipline will not be tolerated and all the decisions would rest in the hands of event-coordinator and branch-coordinator.', 'http://vaividhya.ssasit.org/department-wise-events/mechanical-engineering/mad.aspx', 'Solanki Dhruvin', 'dhruvinsolanki55@gmail.com', 'no', 'no', '1423915361313', '1421155873981', 2),
(48, 'Switch Master', '9:30 am to 11:30 am', 'Mechanical', '', '(Round - 1) [Ground]', 'no', '1.Robot will have to turn on/off all of the switches situated on the ground & than have to turn on the buzzer on the bridge.\n\n2.Two teams will be competing at a time & the winning team will be forwarded to the final round.\n', '1.Only 2 team members are allowed on the game field while the game is on.\n\n2.The teams will not get any time for practicing on the game field.\n\n3.No repairing time will be given while the robot is on the game field.\nIf both the teams are unable to finish the given task, the team with greater points will be considered winner.\n\n 4.Team can touch the robot only three times with a penalty of extra seconds. In such case the bot must restart from the initial position.\n\n5.A switch will be considered pressed only if the corresponding bulb goes off/on.\n\n6.The time and score measured by the organisers will be final.\n', 'http://vaividhya.ssasit.org/department-wise-events/mechanical-engineering/switch-master.aspx', 'Tevar Jagjit', 'jagjittevar@gmail.com', 'Dewansh', 'dewanshmodi@gmail.com', '1423973264006', '1421157621012', 3),
(49, 'Shooter''s Zone', '18 Feb 2015', 'Mechanical', '', '@SSASIT', 'This event is a heavy dose of engineering, entertainment, and evaluation of your eyesight.\n', 'You have to build and come with a air pressurized gun as all the rounds will require its usage.\n\n(For building the gun, you can surf on the internet.)\n\nBullets for the gun will be provided during the event.\n\nThe event will consist of 3 rounds.', '1.The bullet which is going to be provided will have the diameter of 15mm.\n\n2.The shooting range of your gun should be of 5 to 10 m.\n\n3.A team can have 4 members at the most.\n\n4. Material which you have to select for building the gun should be either fibre or PVC.\n(Steel & glass material is strictly prohibited.)\n\n5.If possible a group can bring their own pump as the teams will not get any time for practicing on the game field using the pump of the event organiser.\n\n6.No repairing time will be given if your cylinder is leaks on the game field( so please make sure you check your gun thoroughly before the event).\n\n7.The score measured by the event organiser will be final.\n\n8. Any indiscipline in the campus may lead to the cancellation of your registration.', 'http://vaividhya.ssasit.org/department-wise-events/mechanical-engineering/shooters-zone.aspx', 'Vaghasiya Sandip', 'sandip.vaghasiya035@gmail.com', 'Kothiya Rajnikant', 'no', '1421157804571', '1421157786203', 2),
(50, 'Mechaholics', '11:30 to 12:30', 'Mechanical', '', '[Round - 1] in Room 111-112', 'This event is made for all... A classic combination for checking your mental prowess and sensing ability.', 'It consists of three rounds:\n1. MECHANICAL CREAMER(Theoretical and conceptual based MCQs)\n2. MECHANICAL BRAIN STORM( Visual and Vocal Rapid Fire Quiz)\n3. MECHANICAL FINALE( divided into two sublevels checking your sensing abilities.....don''t miss the finale friends)', '1. The Checking and Selection Rights will be held solely by the EVENT COORDINATOR. (ROUND-1)\n\n2.The Grouping will be given to students of SAME INSTITUTE. But, In Case There exists variety in the institutes of students, the grouping right will be up-held by the Event Co-Ordinator.(ROUND- 2)\n\n \n\n3.The Decision for the Correctness of the Answer will solely be taken by the QUIZ MASTER while the\nOther Judgments and Tie-Breaker Norms can be Updated Instantaneously.\n\n4.ROUND-3 will be comprising of Two Sub-Rounds [3(A) and 3(B)], where the 8 Students will INDIVIDUALLY lead their own Battle.\n\n5.The Evaluation of the 3(B) will be done only for the TOP 4 from the 3(A).\nClose\n\n6. Any indiscipline in the campus or during the event may lead to the cancellation of your registration.All the decisions will rest in the hands of event and branch coordinator.', 'http://vaividhya.ssasit.org/department-wise-events/mechanical-engineering/mechaholics.aspx', 'Malaviya Dhruvin', 'dhruvin04121994@yahoo.com', 'no', 'no', '1423914577789', '1421157947682', 0),
(51, 'Creometric', '2:30pm to 4:30pm', 'Mechanical', '', '(Round - 2) in Lab 210-B', 'Are you infected with a designing software bug??? Then this event is for you.\n\nThis event puts into test your 3D modelling funda by checking your knowledge about 3D object design, assembly of parts and designing of a working model.', 'This event will consist of three rounds putting you through a series of problems...LETS SEE WHO COMES OUT WITH FLYING COLOURS.\n\n[The name of software is CREO].\n', '1.This event requires a deep knowledge about the designing software CREO.\n\n2. All the criterias for each rounds will be disclosed on the day of the event.\n\n3.Make sure you reach the spot of event within the stipulated time.\n\n4. Any indiscipline in the lab or within the campus may lead to cancellation of your registration.\n\n5. No refund will be provided once you have registered yourself with the event.\n\n6. All the decisions rest in the hands of event and branch coordinator.\n\n7. Only 3 members are allowed in a team.', 'http://vaividhya.ssasit.org/department-wise-events/mechanical-engineering/creometric.aspx', 'Nimesh Boda', 'nimeshboda@gmail.com', 'Yogesh Chheta', 'no', '1423915149616', '1421158151967', 7),
(52, 'LAN of Thrones', '10:00 pm to 12:00 pm', 'Computer', '', '2st day only CS & COD in lab 217-B', 'Computer department provides entertainment to students by LAN game-"Counter strike" & Need for Speed (Car Racing) game which is sheer reflection of speed and teamwork. The gaming experience has given participants ultimate thrill of being together and work as a team.', 'There are 3 types of Game\n\n       CS Source\n       Call Of Duty-3\n       NFS Most Wanted', 'Rule book of CS Source and Call of Duty-3\n\nEach Group contains maximum 4 members.\n\nParticipants can''t use any type of cheat code if any participants use cheat code then the team will be disqualified.\n\nAll participants will be using same map and tools as decided by coordinator.\n\nDon''t speak Abuse words if any participant do, then the team will be disqualified.\n\nFinal decision will be taken by coordinator.\nClose\nNOTE: If any damage is done to the college machine, it will be the sole responsibility of the participant using that machine.\n\nfor more details visit vaividhya site.', 'http://vaividhya.ssasit.org/department-wise-events/computer-engineering/lan-of-thrones.aspx', 'Chinjan Patel', 'patel.chinjan531@gmail.com', 'Dhameliya Krishti', 'krishtidhameliya12@gmail.com', '1424309616958', '1422251260906', 8),
(53, 'Consilium', 'CLOSED [Round-2 cancel]', 'Computer', 'it''s all about design', '', 'An event to build a website \n\nThe purpose of the competition is to produce a 2+ page website based on the competition topic (announced on the day of the competition)\n\nPermitted software are photoshop and dreamviewer', 'Each page must contain the header (menu search box), content (content According to the page) and footer (web link like Facebook, powered by, sponsored by etc...) section\n\nThe emphasis is on the team creating the website. Therefore, any team determined to be cheating, interfering with another team, or interfering with competition servers/workstations, will suffer a severe point deduction or be immediately disqualified from the competition. Any team disqualified from the competition may also be asked to leave the building for the remainder of the competition.\n', '1.Maximum 2 Student Group Allowed\n\n2.Maximum 2 hour Given To Student To Complete Their Task', 'http://vaividhya.ssasit.org/department-wise-events/computer-engineering/consilium.aspx', 'Pathik Devani', 'pathikdevani@gmail.com', 'Aakruti Shah', 'aakruti0913@gmail.com', '1454065551374', '1454065552106', 3),
(54, 'Abhidarshak', '2:30 pm to 6:00 pm', 'Computer', '', 'in room 211', 'A Poster Presentation Event ', 'no', 'Maximum 3 persons are allowed in a group.\n\nTopic of the poster should be related with the Computer Engineering.\n\nParticipants have to use A2 size poster.\n\nList of selected participants will be displayed on the website and selected poster will be presented before judges.', 'http://vaividhya.ssasit.org/department-wise-events/computer-engineering/abhidarshak.aspx', 'Apexa Patel', 'apexa60@gmail.com', 'Hina Savaliya ', 'hinasavaliya17@gmail.com', '1423973668481', '1421160667393', 6),
(55, 'Lekhya Prakashan', '9:30 am to 2:30 pm', 'Computer', '', 'in room 313', 'A Paper Presentation Event\n\nThe main aim of Paper Presentation is to motivate the students and increase their confidence level, enhance their communication skills and express their technical knowledge through PAPER PRESENTATION.', 'Maximum two students per group can present a paper.\n\nOverhead Projector, Multimedia Projector, Slide Projector or Direct Projector will be provided.\n\nPresentation time is 10 min. & 5 min. for question-answer round.\n', 'Paper should not exceed 10 pages excluding title pages, page size being ''A4'', one side printing, single spacing and ''TIMES NEW ROMAN'' with font size 12.\n    Candidates have to submit\n\n    One hard copy\n    One soft copy through E-mail\n    Event''s name and Category should be described.\n\nClose\n\nLast date for final Paper submission: 10/02/2015\n\nSend your Abstract to:: drastichauhan@gmail.com\n\nfor more details visit vaividhya site.', 'http://vaividhya.ssasit.org/department-wise-events/computer-engineering/lekhya-prakashan.aspx', 'Vaghela Mehul', 'aghelamehul12345@gmail.com', 'Gabani Bhavik', 'gabanib22@gmail.com', '1423915605918', '1421160924755', 7),
(56, 'Archetypon', '9:30 am to 12:30 pm ', 'Computer', '', 'in lab 315-c', 'Model presentation event.', 'no', 'Rules for Model Presentation\n\nEach group must consist of 2-4 members.\n\nModel can be software application (Website/Desktop App/Mobile App) or interfacing application with hardware.\n\nIf any external hardware require then participants have to get their own.\n\nBasic configuration will be provided to the participants\n\nModel should be fully working. Error code is not allowed.\n\nLast date for abstract submission: 26/01/2015.\n\nAcceptance Notification : 29/01/2015\nLast date for final Model submission: 16/02/2015\n\nSend Your Abstract to:   maitrypg@gmail.com \n\nEvaluation Criterion\nJury will judge based on the innovativeness and novelty of the model.\nSimplicity of its use.', 'http://vaividhya.ssasit.org/department-wise-events/computer-engineering/archetypon.aspx', 'Hirpara Priyanka', 'priyankahirapara24@gmail.com', 'Karishma Patel', 'karishma.bhavani@gmail.com', '1423973444986', '1421161110213', 0),
(57, 'Reverse Coding', '1:00 pm to 3:00 pm', 'Computer', '', '(Round - 2) in lab 315-B', 'Run Your Logic.', 'We will take Two Rounds.\n\nBoth rounds will 45 min.\n\nWe will give you INPUT AND OUTPUT of any Problem.\n\nYou have to write appropriate code for that problem according to given Output.\n\nYou can write code in C / C++ / JAVA!!!\n\nParticipant come with their Institute I-card and show it when Invilator ask for watch.', 'Group 1:\nIt''s include 1st and 2nd year participant of computer / IT.\nAnd all Participant of other branches (1st, 2nd ,3rd &  4th  Year) \n\nGroup 2:\nIt''s include 3rd and 4th  Year Participant.\n\nmore details visit vaividhya site.', 'http://vaividhya.ssasit.org/department-wise-events/computer-engineering/reverse-coding.aspx', 'Riddhish Bambhroliya', 'riddhish84@gmail.com', 'Bhavika Vaghani ', 'vaghanibhavika98@gmail.com', '1424309665396', '1421161316776', 3),
(58, 'E-Treasurehunt', '18 Feb 2015', 'Computer', '', '@SSASIT', 'no', 'Round:\n\n    GK questions\n    Engineering questions\n     Images questions\n     Zip folder(searching)\n     Game path finding\n     Very tough calculative questions(story based questions)', '1. Only single participant.\n\n2. Winner will be declared based on completion timing.\n\n3. Timing starts after question appears.', 'http://vaividhya.ssasit.org/department-wise-events/computer-engineering/e-treasurehunt.aspx', 'Savaliya Saryu', 'saryusavaliya@gmail.com', 'Kachhadiya Ankita', 'ankukachhadiya9@gmail.com', '1421845986967', '1421161442931', 11);
INSERT INTO `events` (`id`, `name`, `time`, `type`, `tag`, `location`, `intro`, `task`, `rule`, `share_link`, `co1_name`, `co1_email`, `co2_name`, `co2_email`, `last_update`, `last_poster_update`, `color_code`) VALUES
(59, 'Maths Quiz', '11:30 am to 2:30 am', 'General', '', '(Round - 1) in room 412', 'Lets test your math.....', 'Its a four round quiz competition.\n\nFirst round will be MCQ round.\n\nNext three rounds consist of visible, audible, theoretical and practical question related to mathematics.\n\nSecond round will be " Instant Answer Round".\n\nThird round will be "Buster Round".\n\nFourth round will be "Fit Hai To Hit Hai Round".', 'Only single participant is allowed per entry.\n\nOnly qualifiers will be eligible to go in next rounds.\n\nPoints in every rounds will be carry forwarded.\n\n\nVisits Vaividhya sit for more details. ', 'http://vaividhya.ssasit.org/department-wise-events/general-events/maths-quiz.aspx', 'Harsh Vasoya ', 'vasoya.hjv@gmail.com', 'm.vivek0089@gmail.com', 'Mishra Vivek', '1423973573278', '1422375260188', 11);

-- --------------------------------------------------------

--
-- Table structure for table `faculty`
--

CREATE TABLE `faculty` (
  `id` int(10) NOT NULL,
  `name` text NOT NULL,
  `post` text NOT NULL,
  `last_update` text NOT NULL,
  `last_image_update` text NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `faculty`
--

INSERT INTO `faculty` (`id`, `name`, `post`, `last_update`, `last_image_update`) VALUES
(3, 'Prof. J.G. Vaghasia', 'Chief Patron(Vaividhya''15)\n<br>\n(I/C Principal Shree Swami Atmanand Saraswati Institute of Technology)\n\n', '1421900318582', '1421900319713'),
(5, 'Prof. B. J. Mehta', 'Chief Patron(Vaividhya''15)\n<br>\n(Technical Director STBS Trust)', '1421900408831', '1421900408873'),
(6, 'Prof. Nikunj Patel', 'Faculty Convener (Vaividhya''15)\n<br>\n(HOD, Electrical Engineering Department)', '1421900943333', '1421900818839'),
(7, 'Prof. Mitul K.Patel', 'Faculty Convener (Vaividhya''15)\n<br>\n(HOD, Computer Engineering Department)', '1422873790200', '1421900924222'),
(8, 'Prof. Vipul Goti', 'Member of advisory committee (Vaividhya''15)\n<br>\n(HOD, Mechanical Engineering Department)', '1421901343292', '1421901275078'),
(9, 'Prof. Kavita Choksi', 'Member of advisory committee\n<br>\n(HOD,Civil Engineering Department)', '1421901523200', '1421901523272'),
(10, 'Prof. Avani Lakhani', 'Member of advisory committee\n<br>\n(HOD,E&C Engineering Department)', '1421903097639', '1421903097689'),
(11, 'Prof. Tushar Mangukiya', 'Member of advisory committee\n<br>\n(HOD,H&SS Department)', '1421903190614', '1421903137236'),
(12, 'Prof. Drasti J. Chauhan', 'Faculty Head Co-ordinator\n<br>\n(Computer Engineering Department)\n', '1421903561589', '1421903561645'),
(13, 'Prof. Sejal Bhatt', 'Faculty Head Co-ordinator\n<br>\n(Civil Engineering Department)', '1421903627125', '1421903627178'),
(14, 'Prof. Archan Patel', 'Faculty Head Co-ordinator\n<br>\n(Electrical Engineering Department)', '1421904112146', '1421904090111'),
(15, 'Prof. Manish Mistry', 'Faculty Head Co-ordinator\n<br>\n(Mechanical  Engineering Department)', '1421904159314', '1421904139087'),
(16, 'Prof. Dipesh Bhagat', 'Faculty Head Co-ordinator\n<br>\n(E&C  Engineering Department)', '1421904194945', '1421904195004'),
(17, 'Prof. Akhilesh Ladha', 'Treasurer (Vaividhya & Vivir)\n<br>\n(Computer  Engineering Department)', '1423543407141', '1423543407640'),
(18, 'Er. Dksingh', 'Web Admin (Vaividhya)\n<br>\n(Computer  Engineering Department)', '1421904610352', '1421904595044');

-- --------------------------------------------------------

--
-- Table structure for table `news`
--

CREATE TABLE `news` (
  `id` int(11) NOT NULL,
  `title` text NOT NULL,
  `content` text NOT NULL,
  `last_update` text NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `news`
--

INSERT INTO `news` (`id`, `title`, `content`, `last_update`) VALUES
(3, 'Welcome', 'Android applicaiton of vavidhya 2k15 launched.', '1421131347668'),
(4, 'App Update (1.1)', 'App update available on play store. <a href="https://play.google.com/store/apps/details?id=com.spidren.vaividhya2k15&hl=en">click to update.</a>', '1422785148250'),
(6, 'Event Schedule', 'Event Schedule Day-1 updated in application and also available on website <a href="http://vaividhya.ssasit.org/event-schedule.aspx">click to go website time tabel</a>.\n<br/>\n<br/>\nIn Application Open Event > event title > time & location\n<br/>\n<br/>\nNote: some event time is not available in application so go on website or contact particulate event coordinator.\n\n\n', '1423974014257');

-- --------------------------------------------------------

--
-- Table structure for table `sponsor`
--

CREATE TABLE `sponsor` (
  `id` int(10) NOT NULL,
  `name` text NOT NULL,
  `post` text NOT NULL,
  `last_update` text NOT NULL,
  `last_image_update` text NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `sponsor`
--

INSERT INTO `sponsor` (`id`, `name`, `post`, `last_update`, `last_image_update`) VALUES
(2, 'Paradise', 'Sponsor(Vaividhya &Vivir)', '1422097195608', '1422097195655'),
(3, 'Shopper Bazar', 'Sponsor (Vaividhya & Vivir)', '1422097329224', '1422097329271'),
(4, 'Ed World Education', 'Sponsor(Vaividhya & Vivir)', '1422096948597', '1422096948846'),
(5, 'Gate Forum', 'Sponsor(Vaividhya & Vivir)', '1422097492242', '1422097492304'),
(6, 'Shree Advertising', 'Sponsor(Vaividhya & Vivir)', '1422097673111', '1422097673127'),
(7, 'Fast Ticket', 'Sponsor(Vaividhya & Vivir)', '1422097761488', '1422097761535'),
(8, 'A One ', 'Sponsor(Vaividhya & Vivir)', '1422097818589', '1422097818839'),
(9, 'SRK', 'Sponsor (Vaividhya & Vivir)', '1422865353913', '1422865335888'),
(10, 'Gajera', 'Gajera Charitable Trust', '1423722446428', '1423722446781'),
(11, 'Fearless', 'Fearless\nSponsor(Vaividhya & Vivir)', '1424072718622', '1424072663163');

-- --------------------------------------------------------

--
-- Table structure for table `student`
--

CREATE TABLE `student` (
  `id` int(10) NOT NULL,
  `name` text NOT NULL,
  `post` text NOT NULL,
  `last_update` text NOT NULL,
  `last_image_update` text NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `student`
--

INSERT INTO `student` (`id`, `name`, `post`, `last_update`, `last_image_update`) VALUES
(3, 'Vipul Anghan ', 'Student  Co-ordinator\n<br>\n8460511401', '1422418389922', '1421906119195'),
(4, 'Ankita Dankhra', ' Student  Co-ordinator', '1422418404473', '1421905942247'),
(5, 'Sagar Gajera ', 'Student Co-ordinator\n<br>\n9687011121', '1422418427369', '1421906196726'),
(6, 'Bhargav Bhesaniya', 'Student Co-ordinator\n<br>\n8141265992', '1422418434080', '1421906253612'),
(7, 'Pratik Ramoliya', 'Student Co-ordinator\n<br>\n8758015560', '1422418440264', '1421906356672'),
(8, 'Sagar Khunt', 'Student Co-ordinator\n<br>\n8733092282', '1422418446337', '1421906450334'),
(9, 'Keval Goti ', 'Student Co-ordinator\n<br>\n9913726020', '1422418453058', '1421906521876');

-- --------------------------------------------------------

--
-- Table structure for table `user`
--

CREATE TABLE `user` (
  `id` varchar(10) NOT NULL,
  `pass` varchar(10) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `user`
--

INSERT INTO `user` (`id`, `pass`) VALUES
('admin', 'admin');

--
-- Indexes for dumped tables
--

--
-- Indexes for table `events`
--
ALTER TABLE `events`
  ADD PRIMARY KEY (`id`);

--
-- Indexes for table `faculty`
--
ALTER TABLE `faculty`
  ADD PRIMARY KEY (`id`);

--
-- Indexes for table `news`
--
ALTER TABLE `news`
  ADD PRIMARY KEY (`id`);

--
-- Indexes for table `sponsor`
--
ALTER TABLE `sponsor`
  ADD PRIMARY KEY (`id`);

--
-- Indexes for table `student`
--
ALTER TABLE `student`
  ADD PRIMARY KEY (`id`);

--
-- Indexes for table `user`
--
ALTER TABLE `user`
  ADD PRIMARY KEY (`id`);

--
-- AUTO_INCREMENT for dumped tables
--

--
-- AUTO_INCREMENT for table `events`
--
ALTER TABLE `events`
  MODIFY `id` int(10) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=60;
--
-- AUTO_INCREMENT for table `faculty`
--
ALTER TABLE `faculty`
  MODIFY `id` int(10) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=19;
--
-- AUTO_INCREMENT for table `news`
--
ALTER TABLE `news`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=7;
--
-- AUTO_INCREMENT for table `sponsor`
--
ALTER TABLE `sponsor`
  MODIFY `id` int(10) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=12;
--
-- AUTO_INCREMENT for table `student`
--
ALTER TABLE `student`
  MODIFY `id` int(10) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=10;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
