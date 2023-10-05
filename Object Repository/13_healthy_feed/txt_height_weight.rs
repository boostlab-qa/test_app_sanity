<?xml version="1.0" encoding="UTF-8"?>
<MobileElementEntity>
   <description>건강피드 > 성장관리 > 키/몸무게 &quot;00cm (N백분위)&quot;</description>
   <name>txt_height_weight</name>
   <tag></tag>
   <elementGuidId>14e6aece-1497-45cf-96a6-140336f106a0</elementGuidId>
   <selectorMethod>BASIC</selectorMethod>
   <useRalativeImagePath>false</useRalativeImagePath>
   <webElementProperties>
      <isSelected>true</isSelected>
      <matchCondition>equals</matchCondition>
      <name>resource-id</name>
      <type>Main</type>
      <value>com.bbros.sayup.debug:id/heightAndWeightText</value>
      <webElementGuid>11719bf0-f1c4-4d71-8304-f411a50041b3</webElementGuid>
   </webElementProperties>
   <webElementProperties>
      <isSelected>true</isSelected>
      <matchCondition>contains</matchCondition>
      <name>text</name>
      <type>Main</type>
      <value>${text}</value>
      <webElementGuid>b7e43ca2-03ca-4268-92a9-a6f657a17bd2</webElementGuid>
   </webElementProperties>
   <locator>//*[@resource-id = 'com.bbros.sayup.debug:id/heightAndWeightText' and (contains(@text, '${text}') or contains(., '${text}'))]</locator>
   <locatorStrategy>ATTRIBUTES</locatorStrategy>
</MobileElementEntity>
