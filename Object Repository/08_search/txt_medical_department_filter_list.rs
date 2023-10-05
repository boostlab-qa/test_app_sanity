<?xml version="1.0" encoding="UTF-8"?>
<MobileElementEntity>
   <description>검색 > 진료과목 바텀시트 > 리스트</description>
   <name>txt_medical_department_filter_list</name>
   <tag></tag>
   <elementGuidId>c771b36a-29e9-44fd-abc0-14c38a78d0ea</elementGuidId>
   <selectorMethod>BASIC</selectorMethod>
   <useRalativeImagePath>false</useRalativeImagePath>
   <webElementProperties>
      <isSelected>true</isSelected>
      <matchCondition>equals</matchCondition>
      <name>resource-id</name>
      <type>Main</type>
      <value>com.bbros.sayup.debug:id/tv_category_text</value>
      <webElementGuid>d26d4157-f818-41d3-8836-8a842e966b75</webElementGuid>
   </webElementProperties>
   <webElementProperties>
      <isSelected>true</isSelected>
      <matchCondition>equals</matchCondition>
      <name>text</name>
      <type>Main</type>
      <value>${text}</value>
      <webElementGuid>ed2895a4-815c-4717-8e6d-809bd96ee0f4</webElementGuid>
   </webElementProperties>
   <locator>//*[@resource-id = 'com.bbros.sayup.debug:id/tv_category_text' and (@text = '${text}' or . = '${text}')]</locator>
   <locatorStrategy>XPATH</locatorStrategy>
</MobileElementEntity>
