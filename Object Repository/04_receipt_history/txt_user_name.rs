<?xml version="1.0" encoding="UTF-8"?>
<MobileElementEntity>
   <description>진료내역 > 목록 > 본인 이름</description>
   <name>txt_user_name</name>
   <tag></tag>
   <elementGuidId>6f87aa30-8eb9-4ade-8c6e-9fb7d7747b0e</elementGuidId>
   <selectorMethod>BASIC</selectorMethod>
   <useRalativeImagePath>false</useRalativeImagePath>
   <webElementProperties>
      <isSelected>true</isSelected>
      <matchCondition>equals</matchCondition>
      <name>resource-id</name>
      <type>Main</type>
      <value>com.bbros.sayup.debug:id/tvUserName</value>
      <webElementGuid>b2f91da2-af13-4af2-8f7d-1ecd22c89617</webElementGuid>
   </webElementProperties>
   <webElementProperties>
      <isSelected>true</isSelected>
      <matchCondition>equals</matchCondition>
      <name>text</name>
      <type>Main</type>
      <value>${text}</value>
      <webElementGuid>4dcee01f-c722-4b8b-9cbe-677e631be8d8</webElementGuid>
   </webElementProperties>
   <locator>//*[@resource-id = 'com.bbros.sayup.debug:id/tvUserName' and (@text = '${text}' or . = '${text}')]</locator>
   <locatorStrategy>XPATH</locatorStrategy>
</MobileElementEntity>
