<?xml version="1.0" encoding="UTF-8"?>
<MobileElementEntity>
   <description>가족추가 > 이용약관</description>
   <name>btn_add_use</name>
   <tag></tag>
   <elementGuidId>b999cb27-0f81-4b9e-b3ff-a51d1449c80d</elementGuidId>
   <selectorMethod>BASIC</selectorMethod>
   <useRalativeImagePath>false</useRalativeImagePath>
   <webElementProperties>
      <isSelected>true</isSelected>
      <matchCondition>equals</matchCondition>
      <name>resource-id</name>
      <type>Main</type>
      <value>com.bbros.sayup.debug:id/cb_title</value>
      <webElementGuid>a581e2fa-89ba-4a35-aa92-dc3b7a22f2f0</webElementGuid>
   </webElementProperties>
   <webElementProperties>
      <isSelected>true</isSelected>
      <matchCondition>equals</matchCondition>
      <name>text</name>
      <type>Main</type>
      <value>${text}</value>
      <webElementGuid>1d8c4910-daeb-48d1-ba31-a8e1340878fc</webElementGuid>
   </webElementProperties>
   <locator>//*[@resource-id = 'com.bbros.sayup.debug:id/cb_title' and (@text = '${text}' or . = '${text}')]</locator>
   <locatorStrategy>XPATH</locatorStrategy>
</MobileElementEntity>
