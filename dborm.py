from sqlalchemy import Column, Integer, ForeignKey, String, Date
from sqlalchemy.orm import relationship
from sqlalchemy.ext.declarative import declarative_base

BASE = declarative_base()


class Person(BASE):
    __tablename__ = 'person'
    id = Column(Integer, primary_key=True, autoincrement=True)
    name = Column(String)
    tags = relationship('Tags')

    def __init__(self, name):
        self.name = name


class Tags(BASE):
    __tablename__ = 'tags'
    id = Column(Integer, primary_key=True, autoincrement=True)
    person_id = Column(Integer, ForeignKey('person.id'))
    name_variable = Column(String)

    def __init__(self, name_var, person_id):
        self.name_var = name_var
        self.person_id = person_id


class Sites(BASE):
    __tablename__ = 'sites'
    id = Column(Integer, primary_key=True, autoincrement=True)
    name = Column(String)
    url = Column(String)
    site_map_url = (String)
    start_date = Column(Date)
    pages = relationship('Pages')

    def __init__(self, name, url, site_map=None):
        self.name = name
        self.url = url
        self.site_map_url = site_map


class Pages(BASE):
    __tablename__ = 'pages'
    id = Column(Integer, primary_key=True, autoincrement=True)
    site_id = Column(Integer, ForeignKey('Sites.id'))
    path = Column(String)
    start_date_update = Column(Date)

    def __init__(self, url, site_id, path):
        self.path = url
        self.site_id = site_id
        self.path = path


class PagePersonRank(BASE):
    __tablename__ = 'page_person_rank'
    id = Column(Integer, primary_key=True, autoincrement=True)
    person_id = Column(Integer, ForeignKey('person.id'))
    page_id = Column(Integer, ForeignKey('pages.id'))
    person_rank = Column(Integer)
    date_rank = Column(Date)

    def __init__(self, page, person):
        self.page_id = page
        self.person_id = person