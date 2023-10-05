<?xml version="1.0" encoding="UTF-8"?>
<MobileElementEntity>
   <description>마이페이지 > 개인정보 수정 > 주소 영역</description>
   <name>txt_adress</name>
   <tag></tag>
   <elementGuidId>7e16b310-ea00-4ade-a470-1f93c54fbdf6</elementGuidId>
   <selectorMethod>BASIC</selectorMethod>
   <useRalativeImagePath>false</useRalativeImagePath>
   <webElementProperties>
      <isSelected>true</isSelected>
      <matchCondition>equals</matchCondition>
      <name>resource-id</name>
      <type>Main</type>
      <value>com.bbros.sayup.debug:id/tv_description</value>
      <webElementGuid>a64783ca-2617-49de-a87e-a8dedeba33f9</webElementGuid>
   </webElementProperties>
   <webElementProperties>
      <isSelected>true</isSelected>
      <matchCondition>equals</matchCondition>
      <name>text</name>
      <type>Main</type>
      <value>${text}</value>
      <webElementGuid>172d4d76-5fb5-4c20-8bec-07f2b1a6354d</webElementGuid>
   </webElementProperties>
   <locator>//*[@resource-id = 'com.bbros.sayup.debug:id/tv_description' and (@text = '${text}' or . = '${text}')]</locator>
   <locatorStrategy>XPATH</locatorStrategy>
</MobileElementEntity>
