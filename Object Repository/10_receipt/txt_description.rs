<?xml version="1.0" encoding="UTF-8"?>
<MobileElementEntity>
   <description>접수 > 접수 설정 화면 > 설정 옵션</description>
   <name>txt_description</name>
   <tag></tag>
   <elementGuidId>7a7e7b3e-4c88-4af9-8145-c4f94b94a123</elementGuidId>
   <selectorMethod>BASIC</selectorMethod>
   <useRalativeImagePath>false</useRalativeImagePath>
   <webElementProperties>
      <isSelected>true</isSelected>
      <matchCondition>equals</matchCondition>
      <name>resource-id</name>
      <type>Main</type>
      <value>com.bbros.sayup.debug:id/descriptionTxt</value>
      <webElementGuid>f61cf450-bfd9-49aa-9b39-645f9ceaf04b</webElementGuid>
   </webElementProperties>
   <webElementProperties>
      <isSelected>true</isSelected>
      <matchCondition>equals</matchCondition>
      <name>text</name>
      <type>Main</type>
      <value>${text}</value>
      <webElementGuid>8b70100c-0baa-48d8-8c53-69d20d0454cd</webElementGuid>
   </webElementProperties>
   <locator>//*[@resource-id = 'com.bbros.sayup.debug:id/descriptionTxt' and (@text = '${text}' or . = '${text}')]</locator>
   <locatorStrategy>XPATH</locatorStrategy>
</MobileElementEntity>
