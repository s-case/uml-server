# S-CASE UML Server
This is the API of the UML Server created as part of the EU-funded project [S-CASE](http://www.scasefp7.eu/).
This page serves as usage instructions for the RESTful UML web service.

## Media Types
This API accepts multipart POST request while responses are in XML format (XMI).

## Error States
The common HTTP Response Status Codes are used.

# UML Server Activity Diagrams [/activity]
This is the end point for activity UML diagrams. Any activity diagram to be transformed should use this endpoint with MultiPart POST.
The first part of the MultiPart POST are the image parameters in JSON/XML format, and are the following:
##name
String name: The name of the image file
##format
String format: The format of the image file (jpg, png, bmp)
##imageThreshold
int imageThreshold: The image Threshold [0-255]
##rectangleRate
double rectangleRate: Minimum bounding rectangle rate [0.0-100.0]
##minDistance
double minDistance: Minimum distance between neighboring objects [0.0-)
##minRate
double minRate: Minimum rate of the area covered by an object [0.0-100.0]

The second part is the image file for recognition.

The response is an XMI String describing the UML activity diagram. An example of such file is the following:

<uml:Model xmi:version="20131001" xmlns:xmi="http://www.omg.org/spec/XMI/20131001" xmlns:uml="http://www.eclipse.org/uml2/5.0.0/UML" xmi:id="117f8da6559fc542-1bff275a-4728-8aed-488f8228480e831b5fa68d10" name="model">
  <packagedElement xmi:type="uml:Activity" xmi:id="4db52e102e47ceec-17d183b5-46e9-ae96-2d778f0935cd788b605ff728" name="Activity" node="28fa183f647ae05-3f382155-4ba7-bf46-5f9a0b8f1f78f1b05c37b6cf 4e61f34810463b15-1ae0e915-4ae4-a32b-70f12a9d5f5e227241a58b03 528797b0721399a-706c7d89-4680-99fd-6a24cf84606c552b246f55b4 6ea61ee06a59f4ab-7073ee5e-48e3-b144-602db3494460cfce1467967e 229f467512824e17-30f87f94-4b3a-b655-29d745f9e576db120563fe7">
    <edge xmi:type="uml:ControlFlow" xmi:id="2d7f697e7f7d3f08-2b7bc91b-4079-a96b-278cd3e2336eddb132e32130" name="Select a to report" coordinates="(123,35) (121,98) (120,99) (117,95) (120,101) (123,101) (126,95) (124,99) (122,99) (123,35)" target="4e61f34810463b15-1ae0e915-4ae4-a32b-70f12a9d5f5e227241a58b03" source="28fa183f647ae05-3f382155-4ba7-bf46-5f9a0b8f1f78f1b05c37b6cf"/>
    <edge xmi:type="uml:ControlFlow" xmi:id="6c7b46ead2499b-4f66404-401b-840b-37f0763b36ffd8c9f6465fd" name="View from library Find the file and load" coordinates="(122,177) (124,219) (123,220) (120,216) (123,221) (126,221) (128,214) (126,219) (124,217) (124,192) (122,177)" target="528797b0721399a-706c7d89-4680-99fd-6a24cf84606c552b246f55b4" source="4e61f34810463b15-1ae0e915-4ae4-a32b-70f12a9d5f5e227241a58b03"/>
    <edge xmi:type="uml:ControlFlow" xmi:id="1bcf619a536fa531-3509740c-4697-9376-358c35042eae0d7c23db5b3a" name="the data report Load the at report" coordinates="(125,317) (123,334) (123,360) (121,363) (119,358) (121,365) (124,365) (127,360) (126,359) (125,363) (123,363) (125,317)" target="6ea61ee06a59f4ab-7073ee5e-48e3-b144-602db3494460cfce1467967e" source="528797b0721399a-706c7d89-4680-99fd-6a24cf84606c552b246f55b4"/>
    <edge xmi:type="uml:ControlFlow" xmi:id="4bb0249e24329e2d-3fe9eabc-4eea-b622-3f17a120224a6ae62773c727" name="Interactive report Viewer" coordinates="(120,461) (118,475) (118,497) (116,499) (114,494) (116,500) (120,500) (122,496) (119,500) (118,499) (120,461)" target="229f467512824e17-30f87f94-4b3a-b655-29d745f9e576db120563fe7" source="6ea61ee06a59f4ab-7073ee5e-48e3-b144-602db3494460cfce1467967e"/>
    <node xmi:type="uml:InitialNode" xmi:id="28fa183f647ae05-3f382155-4ba7-bf46-5f9a0b8f1f78f1b05c37b6cf" name="InitialNode" coordinates="(120,10) (115,14) (114,22) (118,27) (126,28) (131,24) (132,16) (128,11) (120,10)"  outgoing="4e61f34810463b15-1ae0e915-4ae4-a32b-70f12a9d5f5e227241a58b03"/>
    <node xmi:type="uml:OpaqueAction" xmi:id="4e61f34810463b15-1ae0e915-4ae4-a32b-70f12a9d5f5e227241a58b03" name="Select a to report View from library" coordinates="(19,112) (19,166) (22,170) (221,170) (224,166) (224,112) (221,108) (22,108) (19,112)" incoming="28fa183f647ae05-3f382155-4ba7-bf46-5f9a0b8f1f78f1b05c37b6cf" outgoing="528797b0721399a-706c7d89-4680-99fd-6a24cf84606c552b246f55b4"/>
    <node xmi:type="uml:OpaqueAction" xmi:id="528797b0721399a-706c7d89-4680-99fd-6a24cf84606c552b246f55b4" name="Find the file and load the data report" coordinates="(11,232) (11,306) (14,310) (237,310) (240,306) (240,232) (237,228) (14,228) (11,232)" incoming="4e61f34810463b15-1ae0e915-4ae4-a32b-70f12a9d5f5e227241a58b03" outgoing="6ea61ee06a59f4ab-7073ee5e-48e3-b144-602db3494460cfce1467967e"/>
    <node xmi:type="uml:OpaqueAction" xmi:id="6ea61ee06a59f4ab-7073ee5e-48e3-b144-602db3494460cfce1467967e" name="Load the at report Interactive report Viewer" coordinates="(11,376) (11,450) (14,454) (229,454) (232,450) (232,376) (229,372) (14,372) (11,376)" incoming="528797b0721399a-706c7d89-4680-99fd-6a24cf84606c552b246f55b4" outgoing="229f467512824e17-30f87f94-4b3a-b655-29d745f9e576db120563fe7"/>
    <node xmi:type="uml:ActivityFinalNode" xmi:id="229f467512824e17-30f87f94-4b3a-b655-29d745f9e576db120563fe7" name="ActivityFinalNode" coordinates="(112,508) (107,515) (108,524) (115,529) (124,528) (129,521) (128,512) (122,507) (112,508)" incoming="6ea61ee06a59f4ab-7073ee5e-48e3-b144-602db3494460cfce1467967e" />
  </packagedElement>
</uml:Model>

# UML Server Use Case Diagrams [/usecase]
This is the end point for use case UML diagrams. Any use case diagram to be transformed should use this endpoint with MultiPart POST.
The request parameters of the MultiPart POST are the same as for activity diagrams.

An example of the response for use case diagrams is the following:

<uml:Model xmi:version="20131001" xmlns:xmi="http://www.omg.org/spec/XMI/20131001" xmlns:uml="http://www.eclipse.org/uml2/5.0.0/UML" xmi:id="63aa4ef357cf3a7e-52ef3ae1-4a03-afca-83ffaae1fccbd736fda23e9" name="model">
  <packagedElement xmi:type="uml:Use Case" xmi:id="8b7996f2e554cc-3e1f937b-46f8-8e44-72a14b8a65039d1f7cb7a30d" name="Use Case" node="608c3ac93ae8266-2f650075-4e97-8c6b-2b6fbbff50e4b106534cbe99 5d42718629d33a57-76281741-41a3-8e9c-5d823dc947716b1035560f6c 3c874b5a62478737-62b905b-47a7-ad7d-5f1927f83bf7b85f7656c429 6de70a22524d42b-47621f9-4136-abc8-c79f93222360c07ba34acb 5639b9394b7e47f1-6f7be9d9-4886-b873-d3462a129c8682b7feaa4ef">
    <edge xmi:type="uml:SolidLineFlow" xmi:id="346144c676b3a4c1-2abe99c5-462c-b380-119577e544bc289e2645c0b2" name="CityA Resources sharing Sharing management" coordinates="(177,270) (243,329) (248,332) (182,273) (177,270) (177,270) (248,332)" target="5639b9394b7e47f1-6f7be9d9-4886-b873-d3462a129c8682b7feaa4ef" source="3c874b5a62478737-62b905b-47a7-ad7d-5f1927f83bf7b85f7656c429"/>
    <edge xmi:type="uml:SolidLineFlow" xmi:id="6f25ed5f4aaf4033-43f2ec90-4936-8467-1a1fb2392a711f44be78d0a" name="CityB Data sharing" coordinates="(381,270) (379,270) (317,332) (319,332) (381,270) (317,332) (381,270)" target="5639b9394b7e47f1-6f7be9d9-4886-b873-d3462a129c8682b7feaa4ef" source="6de70a22524d42b-47621f9-4136-abc8-c79f93222360c07ba34acb"/>
    <edge xmi:type="uml:SolidLineFlow" xmi:id="375a46649addd69-b22d8a1-499b-add6-146f33e05d13bfd634381277" name="" coordinates="(177,270) (243,329) (248,332) (182,273) (177,270) (177,270) (248,332)" target="3c874b5a62478737-62b905b-47a7-ad7d-5f1927f83bf7b85f7656c429" source="5639b9394b7e47f1-6f7be9d9-4886-b873-d3462a129c8682b7feaa4ef"/>
    <edge xmi:type="uml:SolidLineFlow" xmi:id="1ad32c005ad0b3a-6d3311f4-4ef6-95da-480e3dc94a757cfd2d463962" name="" coordinates="(381,270) (379,270) (317,332) (319,332) (381,270) (317,332) (381,270)" target="6de70a22524d42b-47621f9-4136-abc8-c79f93222360c07ba34acb" source="5639b9394b7e47f1-6f7be9d9-4886-b873-d3462a129c8682b7feaa4ef"/>
    <node xmi:type="uml:UserNode" xmi:id="608c3ac93ae8266-2f650075-4e97-8c6b-2b6fbbff50e4b106534cbe99" name="" coordinates="(130,12) (124,12) (120,16) (121,24) (127,27) (132,25) (134,22) (134,16) (130,12)" connectedSolid="" connectedDashed="" incomingSolid="" outgoingSolid="" incomingDashed="" outgoingDashed=""/>
    <node xmi:type="uml:UserNode" xmi:id="5d42718629d33a57-76281741-41a3-8e9c-5d823dc947716b1035560f6c" name="" coordinates="(341,12) (337,15) (336,21) (340,26) (344,27) (350,23) (351,17) (348,13) (341,12)" connectedSolid="" connectedDashed="" incomingSolid="" outgoingSolid="" incomingDashed="" outgoingDashed=""/>
    <node xmi:type="uml:UseCaseNode" xmi:id="3c874b5a62478737-62b905b-47a7-ad7d-5f1927f83bf7b85f7656c429" name="Resources sharing" coordinates="(11,235) (11,240) (16,245) (38,254) (69,260) (113,264) (170,264) (221,259) (257,250) (264,247) (272,240) (272,235) (267,230) (252,223) (221,216) (171,211) (112,211) (62,216) (31,223) (19,228) (11,235)" connectedSolid="5639b9394b7e47f1-6f7be9d9-4886-b873-d3462a129c8682b7feaa4ef" connectedDashed="" incomingSolid="" outgoingSolid="" incomingDashed="" outgoingDashed=""/>
    <node xmi:type="uml:UseCaseNode" xmi:id="6de70a22524d42b-47621f9-4136-abc8-c79f93222360c07ba34acb" name="Data sharing" coordinates="(323,235) (323,240) (325,244) (339,253) (358,259) (393,264) (432,264) (467,259) (481,255) (494,249) (500,244) (502,240) (502,235) (500,231) (486,222) (463,215) (432,211) (393,211) (362,215) (344,220) (331,226) (325,231) (323,235)" connectedSolid="5639b9394b7e47f1-6f7be9d9-4886-b873-d3462a129c8682b7feaa4ef" connectedDashed="" incomingSolid="" outgoingSolid="" incomingDashed="" outgoingDashed=""/>
    <node xmi:type="uml:UseCaseNode" xmi:id="5639b9394b7e47f1-6f7be9d9-4886-b873-d3462a129c8682b7feaa4ef" name="Sharing management" coordinates="(139,363) (139,368) (143,372) (162,380) (204,388) (253,392) (317,392) (366,388) (408,380) (422,375) (431,368) (431,363) (427,359) (408,351) (366,343) (318,339) (252,339) (204,343) (162,351) (146,357) (139,363)" connectedSolid="3c874b5a62478737-62b905b-47a7-ad7d-5f1927f83bf7b85f7656c429 6de70a22524d42b-47621f9-4136-abc8-c79f93222360c07ba34acb" connectedDashed="" incomingSolid="" outgoingSolid="" incomingDashed="" outgoingDashed=""/>
  </packagedElement>
</uml:Model>
