<?xml version="1.0" encoding="UTF-8"?>
<MobileElementEntity>
   <description>병원상세 > [{좌측}] 버튼</description>
   <name>btn_left</name>
   <tag></tag>
   <elementGuidId>bd24e520-598e-492e-a337-87ddf60661ce</elementGuidId>
   <selectorMethod>BASIC</selectorMethod>
   <useRalativeImagePath>false</useRalativeImagePath>
   <webElementProperties>
      <isSelected>true</isSelected>
      <matchCondition>equals</matchCondition>
      <name>resource-id</name>
      <type>Main</type>
      <value>com.bbros.sayup.debug:id/tv_left_button</value>
      <webElementGuid>c281b8a6-82c5-4df7-8c12-941008b8c63f</webElementGuid>
   </webElementProperties>
   <webElementProperties>
      <isSelected>true</isSelected>
      <matchCondition>equals</matchCondition>
      <name>text</name>
      <type>Main</type>
      <value>${text}</value>
      <webElementGuid>ef8aafbf-4100-4dcb-8e06-f3296e9d9ad5</webElementGuid>
   </webElementProperties>
   <locator>//*[@resource-id = 'com.bbros.sayup.debug:id/tv_left_button' and (@text = '${text}' or . = '${text}')]</locator>
   <locatorStrategy>XPATH</locatorStrategy>
</MobileElementEntity>
