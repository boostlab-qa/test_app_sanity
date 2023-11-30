<?xml version="1.0" encoding="UTF-8"?>
<MobileElementEntity>
   <description>홈 > 주소 이름 영역</description>
   <name>txt_home_adress_name</name>
   <tag></tag>
   <elementGuidId>30a73f0b-32bd-4f3f-825c-2d7dbb3cb9f8</elementGuidId>
   <selectorMethod>BASIC</selectorMethod>
   <useRalativeImagePath>false</useRalativeImagePath>
   <webElementProperties>
      <isSelected>true</isSelected>
      <matchCondition>equals</matchCondition>
      <name>resource-id</name>
      <type>Main</type>
      <value>com.bbros.sayup.debug:id/tv_title</value>
      <webElementGuid>320d5638-bf76-4e08-850f-c22fb85373d6</webElementGuid>
   </webElementProperties>
   <webElementProperties>
      <isSelected>true</isSelected>
      <matchCondition>equals</matchCondition>
      <name>text</name>
      <type>Main</type>
      <value>${text}</value>
      <webElementGuid>cd92e834-77a9-40b3-b952-c558413ab637</webElementGuid>
   </webElementProperties>
   <locator>//*[@resource-id = 'com.bbros.sayup.debug:id/tv_title' and (@text = '${text}' or . = '${text}')]</locator>
   <locatorStrategy>XPATH</locatorStrategy>
</MobileElementEntity>
