<?xml version="1.0" encoding="UTF-8"?>
<MobileElementEntity>
   <description>진료내역 > 필터</description>
   <name>btn_filter</name>
   <tag></tag>
   <elementGuidId>fadf35db-1532-44b7-9652-e39f255b3b92</elementGuidId>
   <selectorMethod>BASIC</selectorMethod>
   <useRalativeImagePath>false</useRalativeImagePath>
   <webElementProperties>
      <isSelected>true</isSelected>
      <matchCondition>equals</matchCondition>
      <name>resource-id</name>
      <type>Main</type>
      <value>com.bbros.sayup.debug:id/commonBtnTitle</value>
      <webElementGuid>33c312cd-8918-432f-9152-6f1e46b26c33</webElementGuid>
   </webElementProperties>
   <webElementProperties>
      <isSelected>true</isSelected>
      <matchCondition>equals</matchCondition>
      <name>text</name>
      <type>Main</type>
      <value>${text}</value>
      <webElementGuid>211aeaa0-e83a-4835-a4d3-0f3b634e4f68</webElementGuid>
   </webElementProperties>
   <locator>//*[@resource-id = 'com.bbros.sayup.debug:id/commonBtnTitle' and (@text = '${text}' or . = '${text}')]</locator>
   <locatorStrategy>XPATH</locatorStrategy>
</MobileElementEntity>
