<?xml version="1.0" encoding="UTF-8"?>
<MobileElementEntity>
   <description>진료내역 > 진료대상 필터 > 가족</description>
   <name>txt_family_filter</name>
   <tag></tag>
   <elementGuidId>ff9c96b5-d593-43f9-bc6b-199379497485</elementGuidId>
   <selectorMethod>BASIC</selectorMethod>
   <useRalativeImagePath>false</useRalativeImagePath>
   <webElementProperties>
      <isSelected>true</isSelected>
      <matchCondition>equals</matchCondition>
      <name>resource-id</name>
      <type>Main</type>
      <value>com.bbros.sayup.debug:id/family_filter</value>
      <webElementGuid>33ece4c6-d77f-4a32-b794-92428d8731b5</webElementGuid>
   </webElementProperties>
   <webElementProperties>
      <isSelected>true</isSelected>
      <matchCondition>equals</matchCondition>
      <name>text</name>
      <type>Main</type>
      <value>${text}</value>
      <webElementGuid>976c041a-704a-4518-85e0-242fd225af62</webElementGuid>
   </webElementProperties>
   <locator>//*[@resource-id = 'com.bbros.sayup.debug:id/family_filter' and (@text = '${text}' or . = '${text}')]</locator>
   <locatorStrategy>XPATH</locatorStrategy>
</MobileElementEntity>
