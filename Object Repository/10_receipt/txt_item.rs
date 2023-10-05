<?xml version="1.0" encoding="UTF-8"?>
<MobileElementEntity>
   <description>접수 > 진료항목</description>
   <name>txt_item</name>
   <tag></tag>
   <elementGuidId>3cfbb8e6-f827-4555-b74e-fff325d6b5af</elementGuidId>
   <selectorMethod>BASIC</selectorMethod>
   <useRalativeImagePath>false</useRalativeImagePath>
   <webElementProperties>
      <isSelected>true</isSelected>
      <matchCondition>equals</matchCondition>
      <name>resource-id</name>
      <type>Main</type>
      <value>com.bbros.sayup.debug:id/tvName</value>
      <webElementGuid>248dccd6-dc12-4b89-8635-d8f5c262bb01</webElementGuid>
   </webElementProperties>
   <webElementProperties>
      <isSelected>true</isSelected>
      <matchCondition>equals</matchCondition>
      <name>text</name>
      <type>Main</type>
      <value>${text}</value>
      <webElementGuid>45414e86-8e9e-4e86-b86a-6ac6ad76e206</webElementGuid>
   </webElementProperties>
   <locator>//*[@resource-id = 'com.bbros.sayup.debug:id/tvName' and (@text = '${text}' or . = '${text}')]</locator>
   <locatorStrategy>XPATH</locatorStrategy>
</MobileElementEntity>
