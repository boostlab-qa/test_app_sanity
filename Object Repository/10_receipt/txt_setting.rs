<?xml version="1.0" encoding="UTF-8"?>
<MobileElementEntity>
   <description>접수 > 접수 설정</description>
   <name>txt_setting</name>
   <tag></tag>
   <elementGuidId>1027dfd2-0425-4ab7-9d98-fc17711865bd</elementGuidId>
   <selectorMethod>BASIC</selectorMethod>
   <useRalativeImagePath>false</useRalativeImagePath>
   <webElementProperties>
      <isSelected>true</isSelected>
      <matchCondition>equals</matchCondition>
      <name>resource-id</name>
      <type>Main</type>
      <value>com.bbros.sayup.debug:id/titleTxt</value>
      <webElementGuid>7d370dec-1347-4bd8-b6f2-29c0cab8c543</webElementGuid>
   </webElementProperties>
   <webElementProperties>
      <isSelected>true</isSelected>
      <matchCondition>equals</matchCondition>
      <name>text</name>
      <type>Main</type>
      <value>${text}</value>
      <webElementGuid>9d5ffa28-91e8-42d6-a74e-f1c1c24f5643</webElementGuid>
   </webElementProperties>
   <locator>//*[@resource-id = 'com.bbros.sayup.debug:id/titleTxt' and (@text = '${text}' or . = '${text}')]</locator>
   <locatorStrategy>XPATH</locatorStrategy>
</MobileElementEntity>
