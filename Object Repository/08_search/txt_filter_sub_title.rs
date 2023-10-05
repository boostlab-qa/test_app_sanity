<?xml version="1.0" encoding="UTF-8"?>
<MobileElementEntity>
   <description>검색 > 필터 화면 > 서브 타이틀</description>
   <name>txt_filter_sub_title</name>
   <tag></tag>
   <elementGuidId>ffaa55e2-537f-4a7a-96aa-9fc2f3c5fc16</elementGuidId>
   <selectorMethod>BASIC</selectorMethod>
   <useRalativeImagePath>false</useRalativeImagePath>
   <webElementProperties>
      <isSelected>true</isSelected>
      <matchCondition>equals</matchCondition>
      <name>resource-id</name>
      <type>Main</type>
      <value>com.bbros.sayup.debug:id/subTitleTxt</value>
      <webElementGuid>548b645c-5643-4736-ac27-de2bdb4cccb9</webElementGuid>
   </webElementProperties>
   <webElementProperties>
      <isSelected>true</isSelected>
      <matchCondition>equals</matchCondition>
      <name>text</name>
      <type>Main</type>
      <value>${text}</value>
      <webElementGuid>e8feb343-c7b1-41dd-b9d4-dcf5a6ced2d4</webElementGuid>
   </webElementProperties>
   <locator>//*[@resource-id = 'com.bbros.sayup.debug:id/subTitleTxt' and (@text = '${text}' or . = '${text}')]</locator>
   <locatorStrategy>XPATH</locatorStrategy>
</MobileElementEntity>
