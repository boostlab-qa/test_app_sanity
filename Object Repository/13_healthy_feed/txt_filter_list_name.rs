<?xml version="1.0" encoding="UTF-8"?>
<MobileElementEntity>
   <description>건강피드 > 보기 필터 > 필터 목록</description>
   <name>txt_filter_list_name</name>
   <tag></tag>
   <elementGuidId>987c3b23-b83a-4e72-b8d8-c20244c81463</elementGuidId>
   <selectorMethod>BASIC</selectorMethod>
   <useRalativeImagePath>false</useRalativeImagePath>
   <webElementProperties>
      <isSelected>true</isSelected>
      <matchCondition>equals</matchCondition>
      <name>resource-id</name>
      <type>Main</type>
      <value>com.bbros.sayup.debug:id/nameTxt</value>
      <webElementGuid>ca2b127e-0352-4bb5-9684-0731034ca2b8</webElementGuid>
   </webElementProperties>
   <webElementProperties>
      <isSelected>true</isSelected>
      <matchCondition>equals</matchCondition>
      <name>text</name>
      <type>Main</type>
      <value>${text}</value>
      <webElementGuid>33461e43-7b08-407c-bd0f-ae7aa8f3607f</webElementGuid>
   </webElementProperties>
   <locator>//*[@resource-id = 'com.bbros.sayup.debug:id/nameTxt' and (@text = '${text}' or . = '${text}')]</locator>
   <locatorStrategy>XPATH</locatorStrategy>
</MobileElementEntity>
