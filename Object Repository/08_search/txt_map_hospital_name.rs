<?xml version="1.0" encoding="UTF-8"?>
<MobileElementEntity>
   <description>검색 > 병원 지도 > 병원명</description>
   <name>txt_map_hospital_name</name>
   <tag></tag>
   <elementGuidId>1db99b56-7196-40ed-b9f4-7059c6c5559d</elementGuidId>
   <selectorMethod>BASIC</selectorMethod>
   <useRalativeImagePath>false</useRalativeImagePath>
   <webElementProperties>
      <isSelected>true</isSelected>
      <matchCondition>equals</matchCondition>
      <name>resource-id</name>
      <type>Main</type>
      <value>com.bbros.sayup.debug:id/titleTxt</value>
      <webElementGuid>b5a926c5-03d7-4c20-89ac-94d5f19ab5c7</webElementGuid>
   </webElementProperties>
   <webElementProperties>
      <isSelected>true</isSelected>
      <matchCondition>equals</matchCondition>
      <name>text</name>
      <type>Main</type>
      <value>${text}</value>
      <webElementGuid>19bc05c2-e4f6-41dd-b4ce-975b20d5f40c</webElementGuid>
   </webElementProperties>
   <locator>//*[@resource-id = 'com.bbros.sayup.debug:id/titleTxt' and (@text = '${text}' or . = '${text}')]</locator>
   <locatorStrategy>XPATH</locatorStrategy>
</MobileElementEntity>
