<?xml version="1.0" encoding="UTF-8"?>
<MobileElementEntity>
   <description>검색 > 주소 이름</description>
   <name>txt_search_adress_name</name>
   <tag></tag>
   <elementGuidId>4406c1f2-38cd-499f-923f-bd27b4acf4ea</elementGuidId>
   <selectorMethod>BASIC</selectorMethod>
   <useRalativeImagePath>false</useRalativeImagePath>
   <webElementProperties>
      <isSelected>true</isSelected>
      <matchCondition>equals</matchCondition>
      <name>resource-id</name>
      <type>Main</type>
      <value>com.bbros.sayup.debug:id/commonBtnTitle</value>
      <webElementGuid>708a7a0a-f223-4aa8-a09a-edf361e148c0</webElementGuid>
   </webElementProperties>
   <webElementProperties>
      <isSelected>true</isSelected>
      <matchCondition>equals</matchCondition>
      <name>text</name>
      <type>Main</type>
      <value>${text}</value>
      <webElementGuid>8fe13230-7c7d-442f-a67e-66e082c8adbf</webElementGuid>
   </webElementProperties>
   <locator>//*[@resource-id = 'com.bbros.sayup.debug:id/commonBtnTitle' and (@text = '${text}' or . = '${text}')]</locator>
   <locatorStrategy>XPATH</locatorStrategy>
</MobileElementEntity>
