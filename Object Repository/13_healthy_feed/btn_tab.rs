<?xml version="1.0" encoding="UTF-8"?>
<MobileElementEntity>
   <description>건강피드 > tab (건강, 검진/접종, 성장, 체온)</description>
   <name>btn_tab</name>
   <tag></tag>
   <elementGuidId>7bf44e59-2de1-4964-b601-e11a2643ca41</elementGuidId>
   <selectorMethod>BASIC</selectorMethod>
   <useRalativeImagePath>false</useRalativeImagePath>
   <webElementProperties>
      <isSelected>true</isSelected>
      <matchCondition>equals</matchCondition>
      <name>resource-id</name>
      <type>Main</type>
      <value>com.bbros.sayup.debug:id/baseTabText</value>
      <webElementGuid>230b2565-f674-4f26-a195-b92558afce20</webElementGuid>
   </webElementProperties>
   <webElementProperties>
      <isSelected>true</isSelected>
      <matchCondition>equals</matchCondition>
      <name>text</name>
      <type>Main</type>
      <value>${text}</value>
      <webElementGuid>2a6cd58f-d536-4df1-b75f-0c3a802e3dc5</webElementGuid>
   </webElementProperties>
   <locator>//*[@resource-id = 'com.bbros.sayup.debug:id/baseTabText' and (@text = '${text}' or . = '${text}')]</locator>
   <locatorStrategy>XPATH</locatorStrategy>
</MobileElementEntity>
