<?xml version="1.0" encoding="UTF-8"?>
<MobileElementEntity>
   <description>건강피드 > 키/몸무게/체온/해열제/처방전 등록</description>
   <name>txt_add</name>
   <tag></tag>
   <elementGuidId>38f9f94c-f4fc-4087-89f3-ed3bf30a28d2</elementGuidId>
   <selectorMethod>BASIC</selectorMethod>
   <useRalativeImagePath>false</useRalativeImagePath>
   <webElementProperties>
      <isSelected>true</isSelected>
      <matchCondition>equals</matchCondition>
      <name>resource-id</name>
      <type>Main</type>
      <value>com.bbros.sayup.debug:id/text</value>
      <webElementGuid>5997a3c1-d47e-4bfd-a650-2d3784170fc5</webElementGuid>
   </webElementProperties>
   <webElementProperties>
      <isSelected>true</isSelected>
      <matchCondition>equals</matchCondition>
      <name>text</name>
      <type>Main</type>
      <value>${text}</value>
      <webElementGuid>e776c722-07ef-496f-aebe-8ef524b348f6</webElementGuid>
   </webElementProperties>
   <locator>//*[@resource-id = 'com.bbros.sayup.debug:id/text' and (@text = '${text}' or . = '${text}')]</locator>
   <locatorStrategy>XPATH</locatorStrategy>
</MobileElementEntity>
