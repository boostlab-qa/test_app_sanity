<?xml version="1.0" encoding="UTF-8"?>
<MobileElementEntity>
   <description>찜한 목록 > 병원명 영역</description>
   <name>txt_hospital_name</name>
   <tag></tag>
   <elementGuidId>63e46795-20ae-4d78-941f-346a555adbf8</elementGuidId>
   <selectorMethod>BASIC</selectorMethod>
   <useRalativeImagePath>false</useRalativeImagePath>
   <webElementProperties>
      <isSelected>true</isSelected>
      <matchCondition>equals</matchCondition>
      <name>resource-id</name>
      <type>Main</type>
      <value>com.bbros.sayup.debug:id/tv_favorite_title</value>
      <webElementGuid>4df54d47-5511-46ef-aa87-914ff4ac14cf</webElementGuid>
   </webElementProperties>
   <webElementProperties>
      <isSelected>true</isSelected>
      <matchCondition>equals</matchCondition>
      <name>text</name>
      <type>Main</type>
      <value>${text}</value>
      <webElementGuid>5891ae21-9e72-4b63-949c-c10fda1d23a6</webElementGuid>
   </webElementProperties>
   <locator>//*[@resource-id = 'com.bbros.sayup.debug:id/tv_favorite_title' and (@text = '${text}' or . = '${text}')]</locator>
   <locatorStrategy>XPATH</locatorStrategy>
</MobileElementEntity>
