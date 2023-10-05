<?xml version="1.0" encoding="UTF-8"?>
<MobileElementEntity>
   <description>예약 > 날짜선택 > day</description>
   <name>btn_day</name>
   <tag></tag>
   <elementGuidId>3868e474-fea1-448e-a4d0-f56a3d72c108</elementGuidId>
   <selectorMethod>BASIC</selectorMethod>
   <useRalativeImagePath>false</useRalativeImagePath>
   <webElementProperties>
      <isSelected>true</isSelected>
      <matchCondition>equals</matchCondition>
      <name>resource-id</name>
      <type>Main</type>
      <value>com.bbros.sayup.debug:id/dayTxt</value>
      <webElementGuid>839bbea9-8e2c-446c-a321-9aed92388b63</webElementGuid>
   </webElementProperties>
   <webElementProperties>
      <isSelected>true</isSelected>
      <matchCondition>equals</matchCondition>
      <name>text</name>
      <type>Main</type>
      <value>${text}</value>
      <webElementGuid>a0ad31db-b08e-4aa1-ae05-3fdfb4244678</webElementGuid>
   </webElementProperties>
   <locator>//*[@resource-id = 'com.bbros.sayup.debug:id/dayTxt' and (@text = '${text}' or . = '${text}')]</locator>
   <locatorStrategy>XPATH</locatorStrategy>
</MobileElementEntity>
