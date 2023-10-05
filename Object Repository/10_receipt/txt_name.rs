<?xml version="1.0" encoding="UTF-8"?>
<MobileElementEntity>
   <description>진료 대상 선택 > 이름</description>
   <name>txt_name</name>
   <tag></tag>
   <elementGuidId>3da470f2-63c3-4e21-8053-07e47b772456</elementGuidId>
   <selectorMethod>BASIC</selectorMethod>
   <useRalativeImagePath>false</useRalativeImagePath>
   <webElementProperties>
      <isSelected>true</isSelected>
      <matchCondition>equals</matchCondition>
      <name>resource-id</name>
      <type>Main</type>
      <value>com.bbros.sayup.debug:id/nameTxt</value>
      <webElementGuid>de8ab45a-153b-406e-a52f-cecd15d13ea7</webElementGuid>
   </webElementProperties>
   <webElementProperties>
      <isSelected>true</isSelected>
      <matchCondition>equals</matchCondition>
      <name>text</name>
      <type>Main</type>
      <value>${text}</value>
      <webElementGuid>be0d1e1d-b14b-48e8-91d0-70ae22be0408</webElementGuid>
   </webElementProperties>
   <locator>//*[@resource-id = 'com.bbros.sayup.debug:id/nameTxt' and (@text = '${text}' or . = '${text}')]</locator>
   <locatorStrategy>XPATH</locatorStrategy>
</MobileElementEntity>
