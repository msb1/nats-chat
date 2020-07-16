const React = require('react');
const initials = require('initials');
const addPx = require('add-px');
const contrast = require('contrast');

/**
 * modified version of index.js from https://github.com/wbinnssmith/react-user-avatar 
 * under MIT license
 */ 

// from https://flatuicolors.com/  (Dutch Colors)
const defaultColors = [
  '#F79F1F',   // Radiant Yellow
  '#A3CB38',   // Android Green
  '#1289A7',   // Mediteranean Sea
  '#D980FA',   // Lavender Tea
  '#EE5A24',   // Puffins Bill
  '#009432',   // Pixelated Grass
  '#0652DD',   // Merchant Marine Blue
  '#9980FA',   // Forgotten Purple
  '#EA2027',   // Red Pigment 
  '#006266',   // Turkish Aqua
  '#1B1464',   // 20000 Leagues Under the Sea
  '#5758BB',   // Circumorbital Ring
  '#B53471',   // Very Berry
  '#833471',   // Hollyhock
  '#6F1E51',   // Magenta Purple
  '#FFC312',   // Sunflower
  '#C4E538',   // Energos
  '#12CBC4',   // Blue Martina
  '#FDA7DF',   // Lavender Rose
  '#ED4C67',   // Bara Red
];

function sumChars(str) {
  let sum = 0;
  for(let i = 0; i < str.length; i++) {
    sum += str.charCodeAt(i);
  }

  return sum;
}

class UserAvatar extends React.Component {
  render() {
    let {
      borderRadius='100%',
      src,
      srcset,
      name,
      color,
      colors=defaultColors,
      size,
      style,
      className
    } = this.props;

    if (!name) throw new Error('UserAvatar requires a name');

    const abbr = initials(name);
    size = addPx(size);

    const imageStyle = {
      display: 'block',
      borderRadius
    };

    const innerStyle = {
      lineHeight: size,
      textAlign: 'center',
      borderRadius
    };

    if (size) {
      imageStyle.width = innerStyle.width = innerStyle.maxWidth = size;
      imageStyle.height = innerStyle.height = innerStyle.maxHeight = size;
    }

    let inner, classes = [className, 'UserAvatar'];
    if (src || srcset) {
      inner = <img className="UserAvatar--img" style={imageStyle} src={src} srcSet={srcset} alt={name} />
    } else {
      let background;
      if (color) {
        background = color;
      } else {
        // pick a deterministic color from the list
        let i = sumChars(name) % colors.length;
        background = colors[i];
      }

      innerStyle.backgroundColor = background;
      innerStyle.color = 'white'

      inner = abbr;
    }

    if (innerStyle.backgroundColor) {
      classes.push(`UserAvatar--${contrast(innerStyle.backgroundColor)}`);
    }

    return (
      <div aria-label={name} className={classes.join(' ')} style={style}>
        <div className="UserAvatar--inner" style={innerStyle}>
          {inner}
        </div>
      </div>
    )
  }
}

export default UserAvatar;
