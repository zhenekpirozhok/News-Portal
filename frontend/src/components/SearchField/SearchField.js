import {React, useState} from "react";
import { Input, Button } from "antd";
import { SearchOutlined } from "@ant-design/icons";
import { useSelector } from "react-redux";
import { useDispatch } from "react-redux";
import { setSearchValue } from "../../redux/search/actions";
import "./SearchField.css";

const SearchField = ({onSearch}) => {
  const searchValue = useSelector((state) => state.search.searchValue);

  const [searchState, setSearchState] = useState(searchValue);

  return (
    <div className="search-field-container">
      <h2 className="search-title">Search:</h2>
      <div className="search-input-container">
        <Input
          className="search-input"
          placeholder="Enter your search query"
          value={searchState}
          onChange={(e) => {
            setSearchState(e.target.value);
          }}
          onPressEnter={() => onSearch({ value: searchState })}
        />
        <Button
          icon={<SearchOutlined style={{ color: "white" }} />}
          className="search-button"
          onClick={() => onSearch({ value: searchState })}
        />
      </div>
    </div>
  );
};

export default SearchField;
