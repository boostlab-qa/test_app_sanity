<?xml version="1.0" encoding="UTF-8"?>
<MobileElementEntity>
   <description>홈 > 병원 추천 영역 > 병원 이름</description>
   <name>txt_recommend_hospital_name</name>
   <tag></tag>
   <elementGuidId>e137c0c0-d104-4f84-aa1c-0dcef3c1a91a</elementGuidId>
   <selectorMethod>BASIC</selectorMethod>
   <useRalativeImagePath>false</useRalativeImagePath>
   <webElementProperties>
      <isSelected>true</isSelected>
      <matchCondition>equals</matchCondition>
      <name>resource-id</name>
      <type>Main</type>
      <value>com.bbros.sayup.debug:id/tv_title</value>
      <webElementGuid>05fe9802-09c9-487a-92f0-062d0c868f5f</webElementGuid>
   </webElementProperties>
   <webElementProperties>
      <isSelected>true</isSelected>
      <matchCondition>contains</matchCondition>
      <name>text</name>
      <type>Main</type>
      <value>[TEST]</value>
      <webElementGuid>ae15d526-1fa9-4327-ba94-a03623aac2c8</webElementGuid>
   </webElementProperties>
   <locator>//*[@resource-id = 'com.bbros.sayup.debug:id/tv_title' and (contains(@text, '[TEST]') or contains(., '[TEST]'))]</locator>
   <locatorStrategy>ATTRIBUTES</locatorStrategy>
</MobileElementEntity>
